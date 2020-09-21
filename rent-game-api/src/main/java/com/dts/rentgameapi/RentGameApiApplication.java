package com.dts.rentgameapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RentGameApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentGameApiApplication.class, args);
    }
}
