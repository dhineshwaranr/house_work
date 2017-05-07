package com.house.work.configuration;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.datatables.core.web.filter.DatatablesFilter;

@Configuration
public class WebConfig {

	@Bean
    public Filter dandelionFilter() {
        return new DandelionFilter();
    }

    @Bean
    public Filter datatablesFilter() {
        return new DatatablesFilter();
    }
	
}
