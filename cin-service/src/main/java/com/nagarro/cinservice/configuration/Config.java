package com.nagarro.cinservice.configuration;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class Config {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper;
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).enable(true).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.nagarro.cinservice.controller")).build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {

		return new ApiInfo("CIN SERVICE API", "THIS API DELIVERS CIN RELATED OPERATIONS", "1.0 V ",
				"FREE TO USE",
				new springfox.documentation.service.Contact("NAGARRO",
						"https://www.linkedin.com/company/nagarro/mycompany/", "marketing@nagarro.com"),
				"API LICENSE", "", Collections.emptyList());
	}

}
