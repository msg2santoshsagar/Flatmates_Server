package com.alife.flatmates.server.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import liquibase.integration.spring.SpringLiquibase;



/**
 * For configuring database
 * 
 * @author santosh sagar
 * @version 0.0.1
 * @since   26 Dec 2017
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef="springSecurityAuditorAware")
public class DatabaseConfiguration {

	
	/**
	 * To set the path of liquibase change log
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public SpringLiquibase liquibase(DataSource dataSource){
		SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        return liquibase;
	}
	

}
