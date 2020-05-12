package org.example.springcloud.service;
import org.example.springcloud.entities.Payment;

/**
 * @author: songhl
 * @date: 2020/5/8 16:41:05
 * @desc:
 */
public interface PaymentService {
    Payment getPaymentById(Long id);

    int createPayment(Payment payment);
}
