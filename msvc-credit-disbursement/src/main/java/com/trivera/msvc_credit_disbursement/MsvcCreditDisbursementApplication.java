package com.trivera.msvc_credit_disbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcCreditDisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCreditDisbursementApplication.class, args);
	}

}
