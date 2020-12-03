package com.provider_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderLoginApplication.class, args);
    }

}
