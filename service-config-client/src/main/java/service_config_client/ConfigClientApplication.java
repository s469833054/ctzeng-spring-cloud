package service_config_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ______________________________
 *
 * @ClassName ConfigClientApplication
 * @Author ctzeng
 * @Date 2020/6/19 14:57
 * @Version V1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
        System.out.println("配置中心客户端启动成功!");
    }
}

