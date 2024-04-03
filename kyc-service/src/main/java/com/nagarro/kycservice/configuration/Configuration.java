package com.nagarro.kycservice.configuration;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@org.springframework.context.annotation.Configuration
@EnableSwagger2
public class Configuration {

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

	@Bean
	public MappingJackson2HttpMessageConverter httpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(mapper());
		return converter;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, httpMessageConverter());
		return restTemplate;
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper;
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).enable(true).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.nagarro.kycservice.controller")).build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {

		return new ApiInfo("KYC SERVICE API", "THIS API DELIVERS KYC RELATED OPERATIONS", "1.0 V ", "FREE TO USE",
				new springfox.documentation.service.Contact("NAGARRO",
						"https://www.linkedin.com/company/nagarro/mycompany/", "marketing@nagarro.com"),
				"API LICENSE", "", Collections.emptyList());
	}
}
