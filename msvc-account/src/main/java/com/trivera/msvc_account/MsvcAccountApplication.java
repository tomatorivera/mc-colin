package com.trivera.msvc_account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcAccountApplication.class, args);
	}

}
