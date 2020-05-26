package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.OpenFeignPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: songhl
 * @date: 2020/5/13 10:40:24
 * @desc:
 */
@RestController
@Slf4j
public class OrderOpenFeignController {

    @Resource
    private OpenFeignPaymentService openFeignPaymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        log.info("/consumer/payment/get/{}", id);
        return openFeignPaymentService.getPaymentById(id);
    }
}
