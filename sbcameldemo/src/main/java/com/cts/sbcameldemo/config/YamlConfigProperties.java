package com.cts.sbcameldemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration("springManagedYamlConfigProperties")
@EnableConfigurationProperties
@ConfigurationProperties
@RefreshScope
public class YamlConfigProperties {
	
	
	@Value("${test.value}")
	private String testEnvValue;
	
	@Value("${secondURL}")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTestEnvValue() {
		return testEnvValue;
	}

	public void setTestEnvValue(String testEnvValue) {
		this.testEnvValue = testEnvValue;
	}
	
	

}
