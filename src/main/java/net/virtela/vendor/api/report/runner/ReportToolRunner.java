package net.virtela.vendor.api.report.runner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import net.virtela.vendor.api.report.model.Cost;
import net.virtela.vendor.api.report.model.CostReportSummary;
import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.service.FileParserService;
import net.virtela.vendor.api.report.service.PricingService;
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
	
	@Value("${server.env.default}")
	private String serverEnv;
	
	@Value("${cmd.option.file}")
	private String cmdOptionFile;
	
	@Value("${cmd.option.env}")
	private String cmdOptionEnv;
	
	@Value("${cmd.option.print}")
	private String cmdOptionPrint;

	@PostConstruct
	public void init() {
		options = new Options();

		// File Option
		final Option fileOption = Option.builder(this.cmdOptionFile)
										.argName("file")
										.hasArg()
										.required(true)
										.desc("File to process")
										.build();
		
		// Environment Option
		final Option envOption = Option.builder(this.cmdOptionEnv)
									   .argName("environment")
							           .hasArg()
							           .required(false)
							           .desc("Environment to execute")
							           .build();
		
		// Show Details Option
		final Option printOption = Option.builder(this.cmdOptionPrint)
									   	 .argName("print")
									   	 .hasArg()
									   	 .required(false)
									   	 .desc("Print progress to console,")
									   	 .build();

		options.addOption(fileOption);
		options.addOption(envOption);
		options.addOption(printOption);
	}

	@Override
	public void run(String... args) throws Exception {
		final HelpFormatter formatter = new HelpFormatter();
		final CommandLineParser parser = new DefaultParser();
		
		try {
			this.cmd = parser.parse(options, args);
			final String file = this.cmd.getOptionValue(this.cmdOptionFile);
			
			if (CommonHelper.hasValidValue(file)) {
				final List<Address> addressList = this.fileService.getAddressList(file);
				final List<ServiceRequest> serviceList = this.fileService.getService(file);
				
				final String env = this.validateEnv();
				
				for (final Address address : addressList) {
					this.printToConsole("using address: " + address);
					final Set<ServiceRequest> serviceReqList = serviceList.parallelStream()
																		  .filter(s -> address.getServerSetList().contains(s.getId()))
																		  .collect(Collectors.toSet());
					
					for (final ServiceRequest service : serviceReqList) {
						this.printToConsole("with service: " + service);
						final List<Cost> costList = this.pricingService.getPrice(address, service, env);
						this.vendorSet.addAll(costList.parallelStream()
								   					  .map(cost -> cost.getProvider())
								   					  .sorted()
								   					  .collect(Collectors.toSet()));
						
						this.reportList.add(this.summarizeCost(costList, address, service));
					}
				}
				
				this.exportReport(file);
			} else {
				this.printToConsole("File not found.");
			}
		} catch (UnrecognizedOptionException | MissingArgumentException e) {
			formatter.printHelp(Constants.EMPTY_STRING, options);
			System.exit(1);
		}
		
		this.printToConsole("Done!");
	}
	
	private String validateEnv() {
		if (this.cmd.hasOption(this.cmdOptionEnv) && !this.cmd.getOptionValue(this.cmdOptionEnv).isEmpty()) {
			this.serverEnv = this.cmd.getOptionValue(this.cmdOptionEnv);
		}
		return this.serverEnv;
	}
	
	private void printToConsole(String message) {
		if (this.cmd.hasOption(this.cmdOptionPrint) && !this.cmd.getOptionValue(this.cmdOptionPrint).isEmpty()) {
			final String printOptArg = this.cmd.getOptionValue(this.cmdOptionPrint);
			if (CommonHelper.isBooleanFlagActive(printOptArg)) {
				System.out.println(message);
			}
		}
	}
	
	private void exportReport(String filePath) {
		logger.debug("exporting report...");
		final StringBuilder reportFile = new StringBuilder();
		filePath = filePath.replace(Constants.BACK_SLASH, Constants.SLASH);
		
		final String [] fileArr = filePath.split(Constants.SLASH);
		for (int i = 0; i < fileArr.length; i++) {
			if (i == fileArr.length - 1) {
				final String date = new SimpleDateFormat("MMM-dd-yyyy").format(CommonHelper.getDateToday());
				reportFile.append("ApiReport-");
				reportFile.append(date);
				reportFile.append(".xlsx");
				break;
			}
			reportFile.append(fileArr[i]);
			reportFile.append(Constants.SLASH);
		}
		
		final ApiReportExporter reportExporter = new ApiReportExporter();
		reportExporter.populateContent(this.reportList, this.vendorSet);
		reportExporter.saveWorkbook(reportFile.toString());
	}
	
	private CostReportSummary summarizeCost(List<Cost> costList, Address address, ServiceRequest service) {
		final Map<String, Long> tally = costList.parallelStream()
												.filter(cost -> cost.getQbType().equals(this.validQbType))
												.map(cost -> cost.getProvider())
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
