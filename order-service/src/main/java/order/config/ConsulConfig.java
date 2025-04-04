package order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ecwid.consul.v1.ConsulClient;

@Configuration
public class ConsulConfig {

    @Value("${spring.cloud.consul.host}")
    private String host;

    @Value("${spring.cloud.consul.port}")
    private int port;

    @Bean
    public ConsulProperties consulProperties() {
        ConsulProperties properties = new ConsulProperties();
        properties.setHost(host);
        properties.setPort(port);
        return properties;
    }

    @Bean
    public ConsulClient consulClient() {
        return new ConsulClient(host, port);
    }

}
