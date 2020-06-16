package service_consumer.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign自定义拦截器实现认证
 * ______________________________
 *
 * @ClassName FeignBasicAuthRequestInterceptor
 * @Author ctzeng
 * @Date 2020/6/12 15:21
 * @Version V1.0
 **/
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    public FeignBasicAuthRequestInterceptor(){

    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //业务逻辑
    }
}

