package com.task.FoodOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class FoodOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderApplication.class, args);
	}

}
