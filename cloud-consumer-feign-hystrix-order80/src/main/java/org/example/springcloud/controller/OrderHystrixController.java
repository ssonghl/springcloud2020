package org.example.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: songhl
 * @datetime: 2020/5/22 10:02:45
 * @description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallBackMethod") // 默认降级方法
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable(value = "id") Integer id) {
        String paymentInfo_ok = paymentHystrixService.paymentInfo_Ok(id);
        return paymentInfo_ok;
    }

    /**
     * 不指定就使用默认的
     * (fallbackMethod = "globalFallBackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
     * @param id
     * @return
     */
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id) {
        String paymentInfo_timeOut = paymentHystrixService.paymentInfo_TimeOut(id);
        return paymentInfo_timeOut;
    }

    public String globalFallBackMethod() {
        return "我是消费方，80，对方8001系统繁忙，请稍后重试一下";
    }
}
