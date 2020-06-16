package service_provider.web;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import service_provider.model.HouseInfo;

/**
 * ______________________________
 *
 * @ClassName ServiceProviderController
 * @Author ctzeng
 * @Date 2020/6/5 10:39
 * @Version V1.0
 **/
@RestController
@RequestMapping("/provider")
public class ServiceProviderController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(){
        return "Hello"+serverPort;
    }

    /*@GetMapping("/infos")
    public Object serviceUrl(){
        return eurekaClient.getInstancesByVipAddress("service-provider",false);
    }*/

    @GetMapping("/infos")
    public Object serviceUrlByDiscoveryClient(){
        return discoveryClient.getInstances("service-provider");
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return new HouseInfo(1L,"上海","虹口","东体小区");
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return name;
    }

    @PostMapping("/save")
    public Long addData(@RequestBody HouseInfo houseInfo){
        System.out.println(houseInfo.getName());
        return 100L;
    }

    @GetMapping("/choose")
    public Object chooseUrl(){
        ServiceInstance serviceInstance =loadBalancerClient.choose("service-provider");
        return  serviceInstance;
    }
}

