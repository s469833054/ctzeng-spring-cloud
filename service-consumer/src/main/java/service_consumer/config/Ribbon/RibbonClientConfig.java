package service_consumer.config.Ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import service_consumer.config.BeanConfiguration;

/**
 * Ribbon配置使用
 * ______________________________
 *
 * @ClassName RibbonClientConfig
 * @Author ctzeng
 * @Date 2020/6/11 19:49
 * @Version V1.0
 **/
@RibbonClient(name="service-provider",configuration = BeanConfiguration.class)
public class RibbonClientConfig {
}

