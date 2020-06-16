package service_consumer.config.Hystrix;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import service_consumer.config.Feign.ProviderRemoteClient;
import service_consumer.model.HouseInfo;
import service_consumer.model.dto.HouseInfoDto;

/**
 * Feign FallbackFactory回退
 * ______________________________
 *
 * @ClassName ProviderRemoteClientFallBackFactory
 * @Author ctzeng
 * @Date 2020/6/16 10:49
 * @Version V1.0
 **/
@Component
public class ProviderRemoteClientFallBackFactory implements FallbackFactory<ProviderRemoteClient> {
    @Override
    public ProviderRemoteClient create(Throwable throwable) {
        return new ProviderRemoteClient() {
            @Override
            public String hello() {
                return "hello-fail-factory";
            }

            @Override
            public HouseInfoDto houseInfo(Long houseId) {
                HouseInfoDto houseInfoDto = new HouseInfoDto();
                houseInfoDto.setData(new HouseInfo(1l,"","",throwable.getMessage()));
                return houseInfoDto;
            }
        };
    }
}

