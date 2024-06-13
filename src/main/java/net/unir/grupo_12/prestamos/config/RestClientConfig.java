package net.unir.grupo_12.prestamos.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    @LoadBalanced
    public RestClient.Builder restClient() {
        return RestClient.builder();
    }
}
// https://docs.spring.io/spring-cloud-commons/reference/spring-cloud-commons/common-abstractions.html#rest-client-loadbalancer-client
