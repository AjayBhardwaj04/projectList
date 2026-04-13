package com.mountan.productList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductListApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProductListApplication.class, args);
		 ApplicationContext context = SpringApplication.run(ProductListApplication.class, args);
	}

}
