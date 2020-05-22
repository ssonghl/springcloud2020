package org.example.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

/**
 * @author: songhl
 * @date: 2020/5/14 09:57:52
 * @desc:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication8001.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletServletRegistrationBean.setLoadOnStartup(1);
        servletServletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletServletRegistrationBean.setName("hystrixMetricsStreamServlet");
        return servletServletRegistrationBean;
    }
}
