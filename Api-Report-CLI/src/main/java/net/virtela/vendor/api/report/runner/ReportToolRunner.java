package net.virtela.vendor.api.report.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import net.virtela.vendor.api.report.export.ApiReportExporter;
import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.AppConfig;
import net.virtela.vendor.api.report.model.Cost;
import net.virtela.vendor.api.report.model.CostReportSummary;
import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.service.FileParserService;
import net.virtela.vendor.api.report.service.PricingService;
import net.virtela.vendor.api.report.util.CliProgressBar;
import net.virtela.vendor.api.report.util.CommonHelper;
import net.virtela.vendor.api.report.util.Constants;

@Component
@Order(1)
public class ReportToolRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Options options;
	private CommandLine cmd;
	private final Set<String> vendorSet = new HashSet<>();
	private final List<CostReportSummary> reportList = new ArrayList<>();

	@Autowired
	private FileParserService fileService;
	
	@Autowired
	private PricingService pricingService;
	
	@Value("${ws.pricing.valid.type}")
	private String validQbType;
	
	@Value("${progress.bar.refresh.rate}")
	protected long pbRefreshRate;
	
	@Value("${server.env.default}")
	private String defaultServerEnv;
	
	@Value("${cmd.option.path}")
	private String cmdOptionFile;
	
	@Value("${cmd.option.env}")
	private String cmdOptionEnv;
	
	@Value("${cmd.option.cache}")
	private String cmdUseCache;
	
	@Value("${cmd.option.help}")
	private String cmdHelp;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.export.filename.suffix}")
	private String exportFilenameSuffix;
	
	private AtomicInteger totalWork;
	private AtomicInteger progres;
	private CliProgressBar progresBar;
	private AppConfig appConf;

	@PostConstruct
	public void init() {
		this.progres = new AtomicInteger(0);
		this.totalWork = new AtomicInteger(0); 
		this.progresBar = new CliProgressBar();
		this.options = new Options();
		this.appConf = new AppConfig();

		options.addOption(
				Option.builder(this.cmdOptionFile)
					  .argName("path")
					  .longOpt("path")
					  .hasArg()
					  .desc("file path")
					  .build());
		
		options.addOption(
				Option.builder(this.cmdOptionEnv)
			   		  .argName("env")
			   		  .hasArg()
			   		  .longOpt("env")
			   		  .desc("server environment: (tst, sbx, prod)")
			   		  .build());
		
		options.addOption(
				Option.builder(this.cmdUseCache)
		   	 		  .desc("api queries will get from cache")
		   	 		  .build());
		
		options.addOption(
				Option.builder(this.cmdHelp)
					  .longOpt("help")
					  .desc("show available options")
					  .build());
	}

	@Override
	public void run(String... args) throws Exception {
		final CommandLineParser parser = new DefaultParser();
		
		try {
			this.cmd = parser.parse(options, args);
			
			if (this.cmd.hasOption(this.cmdHelp) || this.cmd.hasOption(this.cmdOptionFile) == false) {
				this.showHelp();
			}
			
			final boolean hasRequiredFields = this.initializeConfig();
			
			if (hasRequiredFields) {
				final String file = this.appConf.getTestFilePath(); 
				
				final List<Address> addressList = this.fileService.getAddressList(file);
				final List<ServiceRequest> serviceList = this.fileService.getService(file);
				
				this.initiateProgressBar(addressList, serviceList);
				
				for (final Address address : addressList) {
					final Set<ServiceRequest> serviceReqList = serviceList.parallelStream()
																		  .filter(s -> address.getServerSetList().contains(s.getId()))
																		  .collect(Collectors.toSet());
					
					for (final ServiceRequest service : serviceReqList) {
						final List<Cost> costList = this.pricingService.getPrice(address, service, this.appConf.getEnvironment(), this.appConf.getSkipCache()); 
						this.vendorSet.addAll(costList.parallelStream()
								   					  .map(cost -> cost.getProvider())
								   					  .sorted()
								   					  .collect(Collectors.toSet()));
						
						this.reportList.add(this.summarizeCost(costList, address, service));
						this.progres.incrementAndGet();
					}
				}
				
				final String reportFile = this.exportReport(file);
				
				this.progres.incrementAndGet();
				Thread.sleep(pbRefreshRate);
				
				System.out.println("Report has been created in: " + reportFile); 
			} else {
				System.out.println("File not found.");
			}
		} catch (UnrecognizedOptionException | MissingArgumentException e) {
			this.showHelp();
		}
		
	}
	
	private void showHelp() {
		final HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(this.appName, options);
		System.exit(1);
	}
	
	private String generateReportFileName(String file) {
		final String [] fileArr = file.split(Constants.SLASH);
		final String fileName = fileArr[fileArr.length -1].replace(Constants.DOT + Constants.FILE_TYPE_XLSX, Constants.EMPTY_STRING);

		final String date = new SimpleDateFormat("MMddyyyyhhmmssS").format(CommonHelper.getDateToday());
		
		final String path = new File(".").getAbsolutePath();
		
		final StringBuilder reportFileName = new StringBuilder();
		reportFileName.append(path.substring(0, path.length() - 1));
		reportFileName.append(fileName);
		reportFileName.append(this.exportFilenameSuffix);
		reportFileName.append(date);
		reportFileName.append(Constants.DOT);
		reportFileName.append(Constants.FILE_TYPE_XLSX);
		
		return reportFileName.toString();
	}
	
	private void initiateProgressBar(List<Address> addressList, List<ServiceRequest> serviceList) {
		addressList.parallelStream().forEach(address -> {
			this.totalWork.addAndGet( (int)
									  serviceList.parallelStream()
									  		     .filter(s -> address.getServerSetList().contains(s.getId()))
									  		     .count()
			  		   				);
		});
		this.totalWork.addAndGet(1); // Export Progress
		this.progresBar.setTotal(this.totalWork.get());
		new Thread(() -> {
			while (progres.get() != totalWork.get()) {
				try {
					Thread.sleep(pbRefreshRate);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progresBar.update(progres.get());
			}
		}).start();
	}

	private boolean initializeConfig() {
		
		final String filePath = this.cmd.getOptionValue(this.cmdOptionFile);
		
		if ((new File(filePath)).exists()) {
			
			this.appConf.setTestFilePath(filePath);
			
			if (this.cmd.hasOption(this.cmdOptionEnv) && CommonHelper.hasValidValue(this.cmd.getOptionValue(this.cmdOptionEnv))) {
				
				this.appConf.setEnvironment(this.cmd.getOptionValue(this.cmdOptionEnv));
			} else {
				this.appConf.setEnvironment(this.defaultServerEnv);
			}
			
			if (this.cmd.hasOption(this.cmdUseCache)) {
				this.appConf.setSkipCache(false);
			} else {
				this.appConf.setSkipCache(true);
			}
			
			System.out.println(this.appConf);
			
			return true;
			
		} 
		return false;
	}

	private String exportReport(String filePath) {
		logger.debug("exporting report...");
		filePath = filePath.replace(Constants.BACK_SLASH, Constants.SLASH);
		
		final String [] fileArr = filePath.split(Constants.SLASH);
		
		final StringBuilder reportFile = new StringBuilder();
		reportFile.append(this.generateReportFileName(fileArr[fileArr.length -1]));
		
		final ApiReportExporter reportExporter = new ApiReportExporter();
		reportExporter.populateContent(this.reportList, this.vendorSet);
		reportExporter.saveWorkbook(reportFile.toString());
		
		return reportFile.toString();
	}
	
	private CostReportSummary summarizeCost(List<Cost> costList, Address address, ServiceRequest service) {
		final Map<String, Long> tally = costList.parallelStream()
												.filter(cost -> cost.getQbType().equalsIgnoreCase(this.validQbType))
												.map(Cost::getProvider)
												.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		
		final CostReportSummary report = new CostReportSummary();
		report.setFullAddress(address.toString());
		report.setServiceId(service.getId());
		report.setVirtelaProduct(service.getVirtelaProduct());
		report.setAccessType(service.getAccessType());
		report.setLcc(service.getLcc());
		report.setCircuitSpeed(service.getCircuitSpeed());
		report.setPortSpeed(service.getPortSpeed());
		report.setUpSpeed(service.getUploadSpeed());
		report.setTerm(service.getTerm().toString());
		report.setExactSpeed(service.getExactSpeed());
		report.setResultSummaryMap(tally);
		
		return report;
	}

}
