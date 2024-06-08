package com.progresssoft.deals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class DealsDataWarehouseApplication {
    public static void main(String str[]) {
        SpringApplication.run(DealsDataWarehouseApplication.class, str);
    }
    
}