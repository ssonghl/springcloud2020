package org.example.springcloud.service;

import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: songhl
 * @date: 2020/5/13 10:36:25
 * @desc:
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignPaymentService {

    /**
     * 指定具体接口
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
