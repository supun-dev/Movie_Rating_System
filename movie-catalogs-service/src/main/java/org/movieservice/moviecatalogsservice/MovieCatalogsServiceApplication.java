package org.movieservice.moviecatalogsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogsServiceApplication {

	Logger logger = LoggerFactory.getLogger(MovieCatalogsServiceApplication.class);
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		//Producer method - Creates a RestTemplate ( Singleton ) and distributes anywhere where a RestTemplate is needed.
		logger.info("----- Creating the RestTemplate ----- ");
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogsServiceApplication.class, args);
	}

}
