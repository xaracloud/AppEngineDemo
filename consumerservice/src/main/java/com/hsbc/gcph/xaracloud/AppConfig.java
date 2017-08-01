package com.hsbc.gcph.xaracloud;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

/**
 * Created by subhash on 27/6/17.
 */

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {


    @Named
    public static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.hsbc.gcph.xaracloud.service");
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
