package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @Date: 2021/2/22 10:01
 * @Author: gqLi
 * @Description:
 */
@Slf4j
@RestController
public class OrderController {

    //单服务提供
    // public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 多服务提供,重点是这里，改成 提供者在Eureka 上的名称，而且无需写端口号
     * 还有，消费者里面对RestTemplate配置的config文件，需要更改成如下：（就是加一个注解 @LoadBalanced）
     * 这个注解，就赋予了RestTemplate 负载均衡的能力
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource //@Resource是java原生注解，@Autowired为spring自带
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
