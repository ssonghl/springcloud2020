package org.example.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: songhl
 * @date: 2020/5/12 15:57:13
 * @desc:
 *      自定义配置类不能放在@ComponentScan所扫描包及子包下
 */
@Configuration
public class RibbonRuleConfig {
    @Bean
    public IRule iRule(){
        /**
         * 负载均衡算法  随机
         */
        return new RandomRule();
    }
}
