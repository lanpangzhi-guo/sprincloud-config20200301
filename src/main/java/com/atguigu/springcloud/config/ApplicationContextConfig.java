package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2020
 * @Date: 2021/2/22 09:59
 * @Author: gqLi
 * @Description:
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //这个注解，就赋予了RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
