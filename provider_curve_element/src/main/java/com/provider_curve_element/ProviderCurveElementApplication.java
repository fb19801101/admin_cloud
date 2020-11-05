package com.provider_curve_element;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderCurveElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCurveElementApplication.class, args);
    }

}
