package net.virtela.vendor.api.report.service;

import java.util.List;
import java.util.Set;

import net.virtela.vendor.api.report.model.CostReportSummary;

public interface ReportService {

	public void generateReport(String file, String environment);
	
	public void exportReport(List<CostReportSummary> reportList, Set<String> vendorSet);
}
