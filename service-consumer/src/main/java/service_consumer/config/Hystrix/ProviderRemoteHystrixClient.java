package service_consumer.config.Hystrix;
import org.springframework.stereotype.Component;
import service_consumer.config.Feign.ProviderRemoteClient;
import service_consumer.model.dto.HouseInfoDto;

/**
 * feign回退内容定义
 * ______________________________
 *
 * @ClassName ProviderRemoteHystrixClient
 * @Author ctzeng
 * @Date 2020/6/15 17:44
 * @Version V1.0
 **/
@Component
public class ProviderRemoteHystrixClient implements ProviderRemoteClient {
    @Override
    public String hello() {
        return "fail-hello";
    }

    @Override
    public HouseInfoDto houseInfo(Long houseId) {
        return new HouseInfoDto();
    }
}

