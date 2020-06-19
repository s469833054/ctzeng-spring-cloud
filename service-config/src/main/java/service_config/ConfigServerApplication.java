package service_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ______________________________
 *
 * @ClassName ConfigServerApplication
 * @Author ctzeng
 * @Date 2020/6/19 11:32
 * @Version V1.0
 **/
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}

