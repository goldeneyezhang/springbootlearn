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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yibo.application.model.User;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
//@Import(FeignClientsConfiguration.class)
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
	//private UserFeignClient userUserFeignClient;
	
	//private UserFeignClient adminUserFeignClient;
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	/*@Autowired
	public MovieController(Decoder decoder,Encoder encoder,Client client,Contract contract) {
		//这边的decoder、 encoder、client、contract，可以Debug看看是什么实例
		this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
				.contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user","password1")).
				target(UserFeignClient.class,"http://microservice-provider-user/");
		
		this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
				.contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin","password2")).
				target(UserFeignClient.class,"http://microservice-provider-user/");
	}*/
	
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Integer id) {
		return this.restTemplate.getForObject(userServiceUrl+id, User.class);
	}
	public User findByIdFallback(Integer id) {
		User user= new User();
		user.setId(-1);
		user.setNamecn("默认用户");
		return user;
	}
	//@HystrixCommand(fallbackMethod = "findByIdFallback")
	@GetMapping("/user-user/{id}")
	public User findByIdUser(@PathVariable Integer id) {
		return this.userFeignClient.findById(id);
	}
	/*@GetMapping("/user-admin/{id}")
	public User findByIdAdmin(@PathVariable Integer id) {
		return this.adminUserFeignClient.findById(id);
	}*/
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
