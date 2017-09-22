package net.virtela.vendor.api.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.virtela.vendor.api.report.client.PricingWsClient;
import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.model.Cost;
import net.virtela.vendor.api.report.model.LocationParam;
import net.virtela.vendor.api.report.model.PricingParam;
import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.service.PricingService;
import net.virtela.vendor.api.report.util.CommonHelper;
import net.virtela.vendor.api.report.util.Constants;

@Service
public class PricingServiceImpl implements PricingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PricingWsClient ws;
	
	@Override
	public List<Cost> getPrice(Address address, ServiceRequest service, String env, boolean skipCache) {
		logger.debug("sending request to ws...");
		final List<Cost> costList = new ArrayList<>();
		if (address != null && service != null) {
			final LocationParam locationParam = LocationParam.toLocationParam(address);
			
			final PricingParam pricingParam = new PricingParam();
			pricingParam.setAccessType(service.getAccessType());
			pricingParam.setCostTable(Constants.BOOLEAN_STR_FALSE);
			pricingParam.setDownSpeed(service.getCircuitSpeed());
			pricingParam.setExtactSpeed(service.getExactSpeed());
			pricingParam.setForBulkPricing(Constants.BOOLEAN_STR_TRUE);
			pricingParam.setHistorical(Constants.BOOLEAN_STR_FALSE);
			pricingParam.setHistoricalExact(Constants.BOOLEAN_STR_FALSE);
			pricingParam.setLcc(service.getLcc());
			pricingParam.setLocationParam(locationParam);
			pricingParam.setPortSpeed(service.getPortSpeed().toString());
			pricingParam.setSkipCache(skipCache ? Constants.BOOLEAN_STR_TRUE : Constants.BOOLEAN_STR_FALSE);
			pricingParam.setTerm(service.getTerm().toString());
			pricingParam.setUpSpeed(service.getUploadSpeed());
			pricingParam.setVendorAPI(Constants.BOOLEAN_STR_TRUE);
			pricingParam.setvProduct(service.getVirtelaProduct());
			pricingParam.setvProductID(this.getVirtelaProductIdByName(service.getVirtelaProduct()));
			
			try {
				final String response = this.ws.getPrice( PricingParam.toJson(pricingParam), env);
				costList.addAll(CommonHelper.toList(response, Cost.class));
			} catch (final JsonProcessingException e) {
				logger.error("Error on getting price from web service. " + e.getMessage());
			}
		}
		return costList;
	}
	
	private Long getVirtelaProductIdByName(String vProduct) {
		if (CommonHelper.hasValidValue(vProduct)) {
			switch (vProduct) {
			case Constants.VIRTELA_PRODUCT_VIRTELA_MPLS:
				return Constants.VIRTELA_PRODUCT_MPLS_ID;
			
			case Constants.VIRTELA_PRODUCT_INTERNET_SERVICES:
				return Constants.VIRTELA_PRODUCT_INTERNET_SERVICES_ID;
				
			case Constants.VIRTELA_PRODUCT_BROADBAND_VPN:
				return Constants.VIRTELA_PRODUCT_BROADBAND_VPN_ID;

			default:
				return null;
			}
		}
		return null;
	}
	
}
