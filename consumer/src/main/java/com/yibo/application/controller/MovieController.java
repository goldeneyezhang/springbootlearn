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
import org.springframework.http.HttpHeaders;

@RestController
public class MovieController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		
		return this.restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
	}
	@GetMapping("/user2/{id}")
	public User findByIdFeign(@PathVariable Integer id) {
		return this.userFeignClient.findById(id);
	}
	//@GetMapping("/user-instance")
	//public List<ServiceInstance> showInfo(){
		//return this.discoveryClient.getInstances("microservice-provider-user");
	//}
	/**
	 * ��ѯmicroservice-provider-user�������Ϣ������
	 * @return
	 */
	@GetMapping("/log-instance")
	public void logUserInstance(){
		//return this.discoveryClient.getInstances("microservice-provider-user");
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		//��ӡ��ǰѡ������ĸ��ڵ�
		MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}
}
