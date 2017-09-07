package net.virtela.vendor.api.report.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.Cost;
import net.virtela.vendor.api.report.model.CostReportSummary;
import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.service.FileParserService;
import net.virtela.vendor.api.report.service.PricingService;
import net.virtela.vendor.api.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FileParserService fileService;
	
	@Autowired
	private PricingService pricingService;
	
	@Value("${ws.pricing.valid.type}")
	private String validQbType;
	
	final private Set<String> vendorSet = new HashSet<>();
	final private List<CostReportSummary> reportList = new ArrayList<>();
	
	@Override
	public void generateReport(String file, String environment) {
		final List<Address> addressList = this.fileService.getAddressList(file);
		final List<ServiceRequest> serviceList = this.fileService.getService(file);
		
		for (final Address address : addressList) {
			logger.info("using address: " + address);
			final Set<ServiceRequest> serviceReqList = serviceList.parallelStream()
																  .filter(s -> address.getServerSetList().contains(s.getId()))
																  .collect(Collectors.toSet());
			
			for (final ServiceRequest service : serviceReqList) {
				logger.info("with service: " + service);
				final List<Cost> costList = this.pricingService.getPrice(address, service, environment);
				this.vendorSet.addAll(costList.parallelStream()
						   					  .map(cost -> cost.getProvider())
						   					  .sorted()
						   					  .collect(Collectors.toSet()));
				this.reportList.add(this.summarizeCost(costList, address, service));
			}
		}
		
		this.exportReport();
	}
	
	private void exportReport() {
		logger.info("exporting report...");
		this.vendorSet.forEach(System.out::println);
		this.reportList.forEach(System.out::println);
	}
	
	private CostReportSummary summarizeCost(List<Cost> costList, Address address, ServiceRequest service) {
		final Map<String, Long> tally = costList.parallelStream()
												.filter(cost -> cost.getQbType().equals(this.validQbType))
												.map(cost -> cost.getProvider())
												.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		final CostReportSummary report = new CostReportSummary();
		report.setFullAddress(address.toString());
		report.setServiceId(service.getId());
		report.setResultSummaryMap(tally);
		
		return report;
	}

}
