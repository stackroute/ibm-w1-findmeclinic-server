package com.stackroute.findmeclinic.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.findmeclinic.apigateway.filter.ErrorFilter;
import com.stackroute.findmeclinic.apigateway.filter.PostFilter;
import com.stackroute.findmeclinic.apigateway.filter.PreFilter;
import com.stackroute.findmeclinic.apigateway.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	   public PreFilter preFilter() {
	       return new PreFilter();
	   }
	   @Bean
	   public PostFilter postFilter() {
	       return new PostFilter();
	   }
	   @Bean
	   public ErrorFilter errorFilter() {
	       return new ErrorFilter();
	   }
	   @Bean
	   public RouteFilter routeFilter() {
	       return new RouteFilter();
	   }

}
