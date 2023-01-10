package com.example.demoLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.*;


@SpringBootApplication

public class DemoLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLabApplication.class, args);
	}

}
