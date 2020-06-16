package service_consumer.config.Feign;

import feign.RequestLine;

/**
 * Feign原生直接定义客户端
 * ______________________________
 *
 * @ClassName ProviderRemote
 * @Author ctzeng
 * @Date 2020/6/12 17:45
 * @Version V1.0
 **/
public interface ProviderRemote {

    @RequestLine("GET /provider/hello")
    String hello();
}
