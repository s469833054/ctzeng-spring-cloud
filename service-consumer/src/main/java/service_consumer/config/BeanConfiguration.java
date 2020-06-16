package service_consumer.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置 可以配置负载均衡策略
 * ______________________________
 *
 * @ClassName BeanConfiguration
 * @Author ctzeng
 * @Date 2020/6/5 11:39
 * @Version V1.0
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    //@MyLoadBalanced
    public RestTemplate getRestTmeplate(){
        return new RestTemplate();
    }

    /**
    *自定义负载均衡策略 目前使用的是随机策略 所以先注释
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 18:30
    */
    /*@Bean
    public MyRule myRule(){
        return new MyRule();
    }*/
    /**
     *使用随机负载均衡策略
     *____________________________
     * @author ctzeng
     * @param
     * @return
     * @date 2020/6/12 18:30
     */
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }
}

