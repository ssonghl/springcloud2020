package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: songhl
 * @datetime: 2020/5/22 15:31:48
 * @description:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard9001.class, args);
    }
}
