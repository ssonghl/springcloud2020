package org.example.springcloud.service;

import org.example.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author: songhl
 * @datetime: 2020/5/22 14:03:08
 * @description:
 */
@Component
public class PaymentHystrixFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "paymentInfo_Ok 请稍后重试";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut 请稍后重试啊 少年～";
    }
}
