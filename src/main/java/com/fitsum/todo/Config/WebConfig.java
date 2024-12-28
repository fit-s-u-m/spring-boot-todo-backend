package com.fitsum.todo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Apply CORS for all endpoints
				.allowedOrigins("http://localhost:3000") // Allow requests from localhost:3000 (your front-end)
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
				.allowedHeaders("*"); // Allow all headers
	}
}
