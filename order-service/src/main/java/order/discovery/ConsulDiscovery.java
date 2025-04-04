package order.discovery;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsulDiscovery {

    private final DiscoveryClient discoveryClient;

    public ConsulDiscovery(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public ServiceInstance getServiceUrl(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if (!instances.isEmpty()) {
            return instances.get(0);
        } else {
            return null;
        }
    }
}