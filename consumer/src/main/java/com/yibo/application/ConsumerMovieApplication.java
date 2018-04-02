package com.yibo.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import configuration.ExcudeAnnotation;
import configuration.RibbonConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguration.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(value = {ExcudeAnnotation.class})})
public class ConsumerMovieApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieApplication.class, args);
	}
}
