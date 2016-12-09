package com.spring.henallux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application 
{
	//Permet de démarrer le spring pour lancer le site
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
