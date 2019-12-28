package com.asrori.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.asrori")
public class ConfigRootApplicationContext {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource bean = new DriverManagerDataSource();
        bean.setDriverClassName("org.postgresql.Driver");
        bean.setUrl("jdbc:postgresql://127.0.0.1:5432/springmvc");
        bean.setUsername("postgres");
        bean.setPassword("asrori08");
        return bean;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
