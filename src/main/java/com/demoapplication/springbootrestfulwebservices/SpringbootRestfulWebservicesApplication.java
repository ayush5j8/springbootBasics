package com.demoapplication.springbootrestfulwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info =@Info(
				title="Springboot resyful webservices",
				description = "REST api",
				version = "V1.0",
				contact = @Contact(
						name = "Ayush",
						email="ayush@gmail.com",
						url = "https://www.javaguides.net"
				),
				license=@License(
						name = "Apache 2.0",
						url="https:google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "User management system",
				url = "https://google.com"
		)

)
public class SpringbootRestfulWebservicesApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
