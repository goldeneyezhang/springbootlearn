package com.yibo.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.yibo.application.model.User;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@RestController
public class MovieController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Integer id) {
		System.out.println(userServiceUrl);
		return this.restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
	}
	
	//@GetMapping("/user-instance")
	//public List<ServiceInstance> showInfo(){
		//return this.discoveryClient.getInstances("microservice-provider-user");
	//}
	/**
	 * 查询microservice-provider-user服务的信息并返回
	 * @return
	 */
	@GetMapping("/log-instance")
	public void logUserInstance(){
		//return this.discoveryClient.getInstances("microservice-provider-user");
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		//打印当前选择的是哪个节点
		MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}
}
