package eureka.config;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 服务上下线监控
 * 注：在Eureka集群环境下，每个节点都会触发事件，这个事件需要控制下发送通知的行为，不控制的话每个节点都会发送通知
 * ______________________________
 *
 * @ClassName EurekaStateChangeListener
 * @Author ctzeng
 * @Date 2020/6/9 10:20
 * @Version V1.0
 **/
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        System.err.println(event.getServerId()+event.getAppName()+"服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName()+"进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        System.err.println(event.getServerId()+event.getAppName()+"服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event){
        System.err.println("注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event){
        System.err.println("Eureka Server 启动");
    }
}

