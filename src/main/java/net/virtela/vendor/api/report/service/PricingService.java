package net.virtela.vendor.api.report.service;

import java.util.List;

import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.Cost;
import net.virtela.vendor.api.report.model.ServiceRequest;

public interface PricingService {

	public List<Cost> getPrice(Address address, ServiceRequest service, String env, boolean skipCache);
}
