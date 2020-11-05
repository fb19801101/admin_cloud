package com.provider_other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderOtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOtherApplication.class, args);
    }

}
