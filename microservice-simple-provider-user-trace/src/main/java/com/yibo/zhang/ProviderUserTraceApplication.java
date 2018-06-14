package com.yibo.zhang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserTraceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserTraceApplication.class, args);
	}
}
