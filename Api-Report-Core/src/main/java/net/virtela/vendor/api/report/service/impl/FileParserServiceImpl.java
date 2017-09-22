package net.virtela.vendor.api.report.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.parser.AddressParser;
import net.virtela.vendor.api.report.parser.ServiceRequestParser;
import net.virtela.vendor.api.report.service.FileParserService;

@Service
public class FileParserServiceImpl implements FileParserService {

	private final Logger logger = LoggerFactory.getLogger(FileParserServiceImpl.class);
	
	@Override
	public File openFile(String path) throws FileNotFoundException {
		logger.debug("opening file from " + path);
		final File file = new File(path);
		if (file.exists()) {
			return file;
		}
		throw new FileNotFoundException();
	}

	@Override
	public void printFileContent(File file) throws Exception {
		logger.debug("reading " + file.getName() + " content...");
		try (InputStream in = Files.newInputStream(file.toPath())) {
			final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (final IOException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public List<Address> getAddressList(String filePath) {
		logger.debug("Parsing excel file for list of Address...");
		final List<Address> addressList = new ArrayList<>();
		try {
			final File template = this.openFile(filePath);
			final InputStream fileStream = new FileInputStream(template);
			final AddressParser addressParser = new AddressParser(fileStream);
			addressList.addAll(addressParser.getParsedList());
		} catch (final FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return addressList;
	}

	@Override
	public List<ServiceRequest> getService(String filePath) {
		logger.debug("Parsing template for list of Service Request...");
		final List<ServiceRequest> serviceRequestList = new ArrayList<>();
		try {
			final File template = this.openFile(filePath);
			final InputStream fileStream = new FileInputStream(template);
			final ServiceRequestParser serviceRequestParser = new ServiceRequestParser(fileStream);
			serviceRequestList.addAll(serviceRequestParser.getParsedList());
		} catch (final FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return serviceRequestList;
	}

}
