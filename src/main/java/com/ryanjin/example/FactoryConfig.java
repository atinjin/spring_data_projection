package com.ryanjin.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * spring_data_projection on 2016. 4. 8..
 */
@Configuration
public class FactoryConfig {
    @Bean
    public SpelAwareProxyProjectionFactory projectionFactory() {
        return new SpelAwareProxyProjectionFactory();
    }
}
