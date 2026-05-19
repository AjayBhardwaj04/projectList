package com.mountan.productList;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    private static final Logger log = LoggerFactory.getLogger(ProductListApplication.class);


	static void main(String[] args) {
//		SpringApplication.run(ProductListApplication.class, args);
		SpringApplication.run(ProductListApplication.class, args);
        log.info("Application is starting...");
        log.warn("This is a warning message.");
        log.debug("This is a debug message.");
         log.error("This is an error message.");
         log.info("Application started successfully.");
	}

}
