package com.doneugene.kafkademoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.doneugene.kafkademoapp.*")
@EnableConfigurationProperties(ApplicationProperties.class)
public class KafkaDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoAppApplication.class, args);
	}

}
