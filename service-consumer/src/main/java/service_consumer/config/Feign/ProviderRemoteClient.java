package service_consumer.config.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service_consumer.config.Hystrix.ProviderRemoteHystrixClient;
import service_consumer.model.dto.HouseInfoDto;

/**
 * Feign客户端定义 fallback 可以使用  FallBack方式-fallback传入ProviderRemoteHystrixClient.class
 * FallbackFactory方式 - fallbackFactory传入ProviderRemoteClientFallBackFactory.class
 * ______________________________
 *
 * @ClassName ProviderRemoteClient
 * @Author ctzeng
 * @Date 2020/6/12 14:04
 * @Version V1.0
 **/
@FeignClient(value = "service-provider",path = "/provider",configuration = FeignConfiguration.class, fallback = ProviderRemoteHystrixClient.class)
public interface ProviderRemoteClient {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/{houseId}")
    HouseInfoDto houseInfo(@PathVariable("houseId") Long houseId);
}
