package service_provider.model;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义配置策略配置
 * ______________________________
 *
 * @ClassName BeanConfiguration
 * @Author ctzeng
 * @Date 2020/6/11 19:39
 * @Version V1.0
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public MyRule rule(){
        return new MyRule();
    }
}

