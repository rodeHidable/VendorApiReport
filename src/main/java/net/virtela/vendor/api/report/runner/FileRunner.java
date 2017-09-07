package net.virtela.vendor.api.report.runner;

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

import net.virtela.vendor.api.report.service.ReportService;
import net.virtela.vendor.api.report.util.CommonHelper;
import net.virtela.vendor.api.report.util.Constants;

@Component
@Order(1)
public class FileRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Options options;

	@Autowired
	private ReportService reportService;
	
	@Value("${server.env.default}")
	private String serverEnv;
	
	@Value("${cmd.option.file}")
	private String cmdOptionFile;
	
	@Value("${cmd.option.env}")
	private String cmdOptionEnv;

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

		options.addOption(fileOption);
		options.addOption(envOption);
	}

	@Override
	public void run(String... args) throws Exception {
		final HelpFormatter formatter = new HelpFormatter();
		final CommandLineParser parser = new DefaultParser();
		
		try {
			final CommandLine cmd = parser.parse(options, args);
			final String filePath = cmd.getOptionValue(this.cmdOptionFile);
			
			if (CommonHelper.hasValidValue(filePath)) {
				this.reportService.generateReport(filePath, this.validateEnv(cmd));
			} else {
				logger.error("File not found!");
			}
			
		} catch (UnrecognizedOptionException | MissingArgumentException e) {
			formatter.printHelp(Constants.EMPTY_STRING, options);
			System.exit(1);
		}
		
		logger.info("Done!");
	}
	
	private String validateEnv(CommandLine cmd) {
		if (cmd.hasOption(this.cmdOptionEnv) && !cmd.getOptionValue(this.cmdOptionEnv).isEmpty()) {
			this.serverEnv = cmd.getOptionValue(this.cmdOptionEnv);
		}
		return this.serverEnv;
	}

}
