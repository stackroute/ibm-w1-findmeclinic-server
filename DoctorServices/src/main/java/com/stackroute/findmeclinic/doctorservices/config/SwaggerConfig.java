package com.stackroute.findmeclinic.doctorservices.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	  public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2)
	              .select()                 .apis(RequestHandlerSelectors.basePackage("com.stackroute.findmeclinic.doctorservices.controller"))
	              .paths(regex("/api/v2/doctor.*"))
	              .build()
	              .apiInfo(metaInfo());
	  }


	  private ApiInfo metaInfo() {

	      ApiInfo apiInfo = new ApiInfo(
	              "Spring boot Doctor Service API",
	              "Spring Boot Swagger for Doctor Service",
	              "1.0.0",
	              "Terms of Service",
	              new Contact("Keerthana", "https://www.youtube.com/TechPrimers",
	                      "keerthikaruna20@gmail.com"),
	              "Apache License Version 2.0",
	              "https://www.apache.org/licesen.html"
	      );

	      return apiInfo;
	  }}