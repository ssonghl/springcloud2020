package org.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: songhl
 * @date: 2020/5/13 09:06:58
 * @desc:
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
