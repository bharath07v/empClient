package com.example.empclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/main-controller")
public class EmpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpClientApplication.class, args);
	}

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
//	String url ="http://localhost:100/emp-s/main-controller/get";
	@Value("${emp.service.path}")
	private String url;
	
	@GetMapping("/get")
	public List<String> getEmployees(){
		return restTemplate.getForObject(url+"/main-controller/get", List.class);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
