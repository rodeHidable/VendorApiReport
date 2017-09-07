package net.virtela.vendor.api.report.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PricingWsClient {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	@Value("${ws.pricing.endpoint}")
	private String wsPricingEndpoint;
	
	@Value("${ws.pricing.auth.token}")
	private String wsPricingAuthToken;
	
	public String getPrice(String param, String env) {
		final String endpoint = this.wsPricingEndpoint.replace("{{domain}}", this.getDomain(env));
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Security-Token", this.wsPricingAuthToken);
		
		final HttpEntity<String> request = new HttpEntity<>(param, headers);
		
		
		logger.debug("calling pricing web service using this param: " + param + " and this env: " + endpoint);
		final ResponseEntity<String> response = this.restTemplate.exchange(endpoint, HttpMethod.POST, request, String.class);
		return response.getBody();
	}
	
	private String getDomain(String env) {
		if (env.equals("prod")) {
			return environment.getProperty("server.env.prod");
		} else if (env.equals("sbx")) {
			return environment.getProperty("server.env.sbx");
		} else if (env.equals("tst")) {
			return environment.getProperty("server.env.tst");
		} else {
			return environment.getProperty("server.env.prod");
		}
	}
	
}
