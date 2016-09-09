package br.com.diary.mom.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration
@Configuration
@EntityScan(basePackages={"br.com.diary"})
@EnableMongoRepositories(basePackages={"br.com.diary"})
@EnableConfigurationProperties
public class BaseConfiguration {
  
}