package com.yibo.simple_provider_user_trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
public class ProviderUserTraceZipkinStreamApplication {
	 public static void main(String[] args) {
		 SpringApplication.run(ProviderUserTraceZipkinStreamApplication.class, args);
	 }
}
