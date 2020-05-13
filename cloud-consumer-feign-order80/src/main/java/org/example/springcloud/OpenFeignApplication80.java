package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: songhl
 * @date: 2020/5/13 10:33:04
 * @desc:
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication80.class, args);
    }
}
