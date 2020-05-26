package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: songhl
 * @datetime: 2020/5/25 19:54:05
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-provider-consul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public String getPaymentById(@PathVariable Long id) {
        log.info("/consumer/payment/get/{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul/get/" + id, String.class);
    }
}
