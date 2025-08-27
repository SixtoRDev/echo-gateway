package com.sijareca.restgateway.echo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.sijareca.restgateway.echo.domain")
@EnableJpaRepositories("com.sijareca.restgateway.echo.repos")
@EnableTransactionManagement
public class DomainConfig {
}
