package com.medishare.chicago.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	String jdbcUrl;

	@Value("${spring.datasource.username}")
	String jdbcUser;

	@Value("${spring.datasource.password}")
	String jdbcPass;

	@Value("${spring.datasource.driverClassName}")
	String jdbcProvider;

	BasicDataSource src = null;

	Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

	@Bean
	@PostConstruct
	public DataSource dataSource() {
		if (jdbcUrl == null) {
			throw new RuntimeException("initialization datasource error with null jdbcUrl");
		}
		log.info("Using JDBC ------------> " + jdbcUrl);
		if (src == null) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(jdbcProvider);
			dataSource.setUrl(jdbcUrl);
			dataSource.setUsername(jdbcUser);
			dataSource.setPassword(jdbcPass);
			dataSource.setMaxActive(100);
			dataSource.setMinIdle(3);
			dataSource.setMaxIdle(10);
			dataSource.setMinEvictableIdleTimeMillis(60 * 1000);
			dataSource.setNumTestsPerEvictionRun(100);
			dataSource.setRemoveAbandoned(true);
			dataSource.setRemoveAbandonedTimeout(60 * 1000);
			dataSource.setTestOnBorrow(true);
			dataSource.setTestOnReturn(true);
			dataSource.setTestWhileIdle(true);
			dataSource.setTimeBetweenEvictionRunsMillis(30 * 60 * 1000);
			src = dataSource;
		}
		return src;
	}

}
