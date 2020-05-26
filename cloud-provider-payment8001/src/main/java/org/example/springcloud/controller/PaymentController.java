package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: songhl
 * @date: 2020/5/8 16:37:52
 * @desc:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 创建订单
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        log.info("插入数据开始");
        int result = paymentService.createPayment(payment);
        log.info("插入结果，result={}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功, serverPort" + serverPort, result);
        } else {
            return new CommonResult(200, "插入数据失败, serverPort" + serverPort);
        }
    }

    /**
     * 根据ID查询信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        log.info("查询数据开始，ID为{}", id);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功, serverPort" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询数据失败, serverPort" + serverPort);
        }
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
}
