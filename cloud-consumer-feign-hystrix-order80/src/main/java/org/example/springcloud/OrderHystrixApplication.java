package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: songhl
 * @datetime: 2020/5/22 09:42:01
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApplication.class, args);
    }
}
