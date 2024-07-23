package ru.sharaf.requestforaloanmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class RequestForALoanMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestForALoanMicroserviceApplication.class, args);
    }

}
