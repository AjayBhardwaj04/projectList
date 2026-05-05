package com.mountan.productList;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Product service REST API documentation ",
				description = "Product REST API",
				version = "v1",
				contact = @Contact(
						name = "Ajay",
						email = "ajay@gmail.com"
				)

		)
)
public class ProductListApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProductListApplication.class, args);
		 ApplicationContext context = SpringApplication.run(ProductListApplication.class, args);
	}

}
