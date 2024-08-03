package com.lms.learning_management_system;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningManagementSystemApplication {
	private static final Logger logger = LogManager.getLogger(LearningManagementSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LearningManagementSystemApplication.class, args);
		logger.info("3.This is a Learning Management Platform.");
	}
}


