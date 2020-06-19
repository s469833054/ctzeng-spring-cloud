package service_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service_api.filter.ErrorFilter;
import service_api.filter.IpFilter;

/**
 * ______________________________
 *
 * @ClassName FilterConfig
 * @Author ctzeng
 * @Date 2020/6/18 11:07
 * @Version V1.0
 **/
@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}

