package net.virtela.vendor.api.report;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VendorApiReport {

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(VendorApiReport.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("CommandLineRunner running...");
		};
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
