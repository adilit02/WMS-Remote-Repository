package ait.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"ait.com.controller","ait.com.entity","ait.com.repo","ait.com.service","ait.com.serviceImpl","ait.com.rest"})
@SpringBootApplication
public class WarehouseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagementSystemApplication.class, args);
	}

}
