package service_consumer.filter;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * RestTemplate拦截器定义
 * ______________________________
 *
 * @ClassName LoadBalancerInterceptor
 * @Author ctzeng
 * @Date 2020/6/9 15:39
 * @Version V1.0
 **/
public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        final URI orginalUri = httpRequest.getURI();
        String serviceName = orginalUri.getHost();
        System.out.println("进入自定义的请求拦截器中"+serviceName);
        return clientHttpRequestExecution.execute(httpRequest,bytes);
    }
}

