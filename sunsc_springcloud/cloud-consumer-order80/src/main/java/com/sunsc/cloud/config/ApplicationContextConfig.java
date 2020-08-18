package com.sunsc.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //使用这个注解，赋予了RestTemplate负载均衡的能力，这样就可以通过微服务名称访问到实例
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
