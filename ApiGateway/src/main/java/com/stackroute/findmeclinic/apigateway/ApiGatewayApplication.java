package com.stackroute.findmeclinic.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.stackroute.findmeclinic.apigateway.filter.ErrorFilter;
import com.stackroute.findmeclinic.apigateway.filter.PostFilter;
import com.stackroute.findmeclinic.apigateway.filter.PreFilter;
import com.stackroute.findmeclinic.apigateway.filter.RouteFilter;
import com.stackroute.findmeclinic.apigateway.jwtfilter.JwtFilter;

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
	   
	   @Bean
	    public FilterRegistrationBean jwtFilter() {
		 System.out.println("hihihii");
	        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        registrationBean.setFilter(new JwtFilter());
	        registrationBean.addUrlPatterns("/api/v1/*");
	        return registrationBean;
	    }
	   
	   
	   @Bean
	   public CorsFilter corsFilter() {
	       final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	       final CorsConfiguration config = new CorsConfiguration();
	       config.setAllowCredentials(true);
	       config.addAllowedOrigin("*");
	       config.addAllowedHeader("*");
	       config.addAllowedMethod("OPTIONS");
	       config.addAllowedMethod("HEAD");
	       config.addAllowedMethod("GET");
	       config.addAllowedMethod("PUT");
	       config.addAllowedMethod("POST");
	       config.addAllowedMethod("DELETE");
	       config.addAllowedMethod("PATCH");
	       source.registerCorsConfiguration("/api/v1/*", config);
	       return new CorsFilter(source);	       
	   }
	   

}
