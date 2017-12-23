package com.marck.spring.app.Models.ClienteDao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

public class DataSourceJdbcTemplate {
	@Bean
    public DataSource getDataSource() {

        return dataSource();

    }
	
	private HikariDataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(10);
        ds.setDriverClassName("org.postgresql.ds.PGSimpleDataSource"); 
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/prueba"); ;
        ds.setUsername("marck");
        ds.setPassword("rosas");
        ds.setMinimumIdle(4);
        ds.setIdleTimeout(30000);
        ds.setMaxLifetime(30000);
        ds.setConnectionTimeout(5000);
        return ds;
     }

    @Bean
    public JdbcTemplate getJdbcTemplate() {

        return new JdbcTemplate(getDataSource());
    }
}
