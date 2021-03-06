package service_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心服务端
 * ______________________________
 *
 * @ClassName ConfigServerApplication
 * @Author ctzeng
 * @Date 2020/6/19 11:32
 * @Version V1.0
 **/
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
        System.out.println("配置中心服务端启动成功!");
    }
}

