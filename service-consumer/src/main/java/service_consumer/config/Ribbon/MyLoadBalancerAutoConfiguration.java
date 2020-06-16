package service_consumer.config.Ribbon;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import service_consumer.filter.MyLoadBalanced;
import service_consumer.filter.MyLoadBalancerInterceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ______________________________
 *
 * @ClassName MyLoadBalancerAutoConfiguration
 * @Author ctzeng
 * @Date 2020/6/9 16:47
 * @Version V1.0
 **/
@Configuration
public class MyLoadBalancerAutoConfiguration {

    @MyLoadBalanced
    @Autowired(required = false)
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @Bean
    public MyLoadBalancerInterceptor myLoadBalancerInterceptor(){
        return new MyLoadBalancerInterceptor();
    }

    public SmartInitializingSingleton myLoadBalancerRestTemplateInitializer(){
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate restTemplate : MyLoadBalancerAutoConfiguration.this.restTemplates) {
                    List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                    list.add(myLoadBalancerInterceptor());
                    restTemplate.setInterceptors(list);
                }
            }
        };
    }
}

