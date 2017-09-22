package net.virtela.vendor.api.report.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.ServiceRequest;

public interface FileParserService {

	public File openFile(String path) throws FileNotFoundException;
	
	public void printFileContent(File file) throws Exception;

	public List<Address> getAddressList(String filePath);

	public List<ServiceRequest> getService(String filePath);
}
