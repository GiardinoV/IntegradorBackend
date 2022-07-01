package com.example.trabajoIntegrador;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TrabajoIntegradorApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("C:\\Users\\vgiar\\OneDrive\\Escritorio\\Digital House\\Backend I\\trabajoIntegrador\\trabajoIntegrador\\log4j.properties");
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
	}

}
