package org.example.springcloud.service;

/**
 * @author: songhl
 * @date: 2020/5/14 10:30:27
 * @desc:
 */
public interface PaymentService {
    String paymentInfo_Ok(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
