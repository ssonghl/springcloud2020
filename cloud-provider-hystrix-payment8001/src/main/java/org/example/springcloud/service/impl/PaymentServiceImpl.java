package org.example.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: songhl
 * @date: 2020/5/14 10:31:04
 * @desc:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_Ok(Integer id) {
        int i = 10 / 0;
        return "线程" + Thread.currentThread().getName() + " paymentInfo_Ok, id: " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int i = 10 / 0;
        return "线程" + Thread.currentThread().getName() + " paymentInfo_Ok, id: " + id + "超时方法啊啊啊啊！";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "出现异常，请稍后重试啊～～～  ID:" + id;
    }

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            // 开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数超过峰值 熔断器将会关闭
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间范围
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10"),
            // 失败率超多少跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功！！ 流水号" + serialNumber;
    }

    public String paymentCircuitBreakerHandler(@PathVariable(value = "id") Integer id) {
        return "paymentCircuitBreaker  id不能为负数！！！ID为：" + id;
    }
}
