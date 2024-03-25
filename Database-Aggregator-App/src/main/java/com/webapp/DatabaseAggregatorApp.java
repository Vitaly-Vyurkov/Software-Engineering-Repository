package com.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DatabaseAggregatorApp {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseAggregatorApp.class, args);
	}

}
