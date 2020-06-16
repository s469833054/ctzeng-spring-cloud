package service_consumer.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service_consumer.config.Feign.ProviderRemote;
import service_consumer.config.Feign.ProviderRemoteClient;
import service_consumer.model.HouseInfo;
import service_consumer.model.dto.HouseInfoDto;

/**
 * 服务消费者 RestTemplate调用接口
 * ______________________________
 *
 * @ClassName ConsumerController
 * @Author ctzeng
 * @Date 2020/6/5 11:38
 * @Version V1.0
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderRemoteClient providerRemoteClient;

    @HystrixCommand(fallbackMethod = "defaultCallHello",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy",value = "THREAD")
    })
    @GetMapping("/callHello")
    public String callHello(){
        //String result=  restTemplate.getForObject("http://service-provider/provider/hello",String.class);
        String result = providerRemoteClient.hello();
        System.out.println("调用接口："+result);
        return result;
    }

    @GetMapping("/{houseId}")
    public HouseInfoDto houseinfo(@PathVariable("houseId")Long houseId){
        HouseInfoDto houseInfoDto = providerRemoteClient.houseInfo(houseId);
        System.out.println(houseInfoDto.toString());
        return houseInfoDto;
    }
    @GetMapping("/callHelloWithoutSpring")
    public String callHelloWithoutSpring(){
        ProviderRemote providerRemote = Feign.builder().target(ProviderRemote.class,"http://localhost:8081");
        String result = providerRemote.hello();
        System.out.println("调用结果："+result);
        return result;
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return restTemplate.getForObject("http://service-provider/provider/data?name="+name,HouseInfo.class);
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return restTemplate.getForObject("http://service-provider/provider/data/{name}",String.class,name);
    }

    @GetMapping("/save")
    public Long add(){
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCity("上海");
        houseInfo.setRegion("虹口");
        houseInfo.setName("XXX");
        return restTemplate.postForObject("http://service-provider/provider/save",houseInfo,Long.class);
    }

    /**
    *回退方法定义
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/15 17:22
    */
    public String defaultCallHello(){
        return "fail";
    }
}

