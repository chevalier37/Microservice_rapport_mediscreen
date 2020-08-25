package com.mediscreen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.mediscreen")
public class MircoServiceRapportApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceRapportApplication.class, args);
		//
	}

}
