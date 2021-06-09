package com.cg.pack;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("ServiceRequest api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/serviceRequest/.*"),regex("/serviceRequest/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ServiceRequest API").description("Satyam API reference for developers")
				.termsOfServiceUrl("http://satyam.com").license("satyam License").licenseUrl("satyamborgaonkar@gmail.com")
				.version("1.0").build();
	}

}
