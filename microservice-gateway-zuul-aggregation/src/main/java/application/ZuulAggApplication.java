package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import application.fallback.UserFallbackProvider;

@EnableZuulProxy
@SpringBootApplication
public class ZuulAggApplication {
	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {
		return new UserFallbackProvider();
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ZuulAggApplication.class, args);
	}
}
