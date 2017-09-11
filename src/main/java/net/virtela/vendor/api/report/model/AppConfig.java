package net.virtela.vendor.api.report.model;

public class AppConfig {

	private String testFilePath;
	private String environment;
	private Boolean skipCache;

	public String getTestFilePath() {
		return testFilePath;
	}

	public void setTestFilePath(String testFilePath) {
		this.testFilePath = testFilePath;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Boolean getSkipCache() {
		return skipCache;
	}

	public void setSkipCache(Boolean skipCache) {
		this.skipCache = skipCache;
	}

	@Override
	public String toString() {
		final StringBuilder strVal = new StringBuilder();
		strVal.append("\n").append("Test File Path: ").append(this.testFilePath).append("\n");
		strVal.append("Environment: ").append(this.environment).append("\n");
		strVal.append("No-Cache: ");
		if (this.skipCache) {
			strVal.append("Yes");
		} else {
			strVal.append("No");
		}
		return strVal.toString();
	}
	

}
