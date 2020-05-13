package org.example.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: songhl
 * @date: 2020/5/13 11:08:30
 * @desc: OpenFeign日志配置
 */
@Configuration
public class OpenFeignConfig {
    /**
     * 设置日志的级别
     * NONE：默认的 不显示任何日志
     * BASIC：仅记录请求方法 URL响应状态码 以及响应时间
     * HEADERS：除BASIC中定义的信息外 还有请求以及响应的头信息
     * FULL: 除HEADERS中定义的信息之外 还有请求和响应的正文及元数据
     *
     * @return
     */
    @Bean
    Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
