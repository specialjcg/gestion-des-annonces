package com.postule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan
public class PostuleappApplication extends SpringBootServletInitializer {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(
            "*"); // for /** means all mapping URL, and * for all domain
      }
    };
  }

  @Override
  protected SpringApplicationBuilder
  configure(SpringApplicationBuilder application) {
    return application.sources(PostuleappApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(PostuleappApplication.class, args);
  }
}