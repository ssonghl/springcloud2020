package org.example.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: songhl
 * @datetime: 2020/5/22 09:46:24
 * @description:
 */
@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixFallBackService.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id);
}
