package service_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本地跳转
 * ______________________________
 *
 * @ClassName LocalController
 * @Author ctzeng
 * @Date 2020/6/17 17:28
 * @Version V1.0
 **/
@RestController
public class LocalController {

    @GetMapping("/local/{id}")
    public String local(@PathVariable String id){
        return "/local/"+id;
    }
}

