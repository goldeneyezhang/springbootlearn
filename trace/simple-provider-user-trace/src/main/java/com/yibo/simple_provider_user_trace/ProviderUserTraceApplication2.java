package com.yibo.simple_provider_user_trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserTraceApplication2 {
	 public static void main(String[] args) {
	 SpringApplication.run(ProviderUserTraceApplication2.class, args);
	 }
}
