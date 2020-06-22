package service_config_client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ______________________________
 *
 * @ClassName ClientController
 * @Author ctzeng
 * @Date 2020/6/19 15:09
 * @Version V1.0
 **/
@RestController
@RefreshScope
public class ClientController {

    @Value("${word}")
    private String word;

    @RequestMapping("/hello")
    public String config(@RequestParam String name){
        return name +","+this.word;
    }
}

