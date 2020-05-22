package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: songhl
 * @date: 2020/5/14 10:40:33
 * @desc:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Ok(id);
        log.info("/payment/hystrix/ok/{}, 返回结果: {}", id, result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("/payment/hystrix/timeout/{}, 返回结果: {}", id, result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/circuitbreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("/payment/hystrix/circuitbreaker/{}, 返回结果: {}", id, result);
        return result;
    }
}
