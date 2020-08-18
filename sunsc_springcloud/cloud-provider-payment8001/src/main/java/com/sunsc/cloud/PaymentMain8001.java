package com.sunsc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//主启动类
@SpringBootApplication
@EnableEurekaClient  //如果需要向eureka注册中心注册  需要自身作为客户端
@EnableDiscoveryClient //开启Discovery功能
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
