package zipkin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * ______________________________
 *
 * @ClassName ZipkinApplication
 * @Author ctzeng
 * @Date 2020/6/23 10:36
 * @Version V1.0
 **/
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }
}

