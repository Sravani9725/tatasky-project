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
	return new Docket(DocumentationType.SWAGGER_2).groupName("TataSky-api").apiInfo(apiInfo()).select().paths(Postpaths()).build();

	}
	private Predicate<String> Postpaths()
	{
		return or(regex("/packs/,*"),regex("/packs/.*"));
	}
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("TataSky API").description("TataSky Application").termsOfServiceUrl("https://tatasky2.com").license("TataSky Industries CopyRight License")
				.licenseUrl("tatasky.customercare.com").version("1.0").build();
	}
	}

