package service_provider.model;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义负载策略
 * ______________________________
 *
 * @ClassName MyRule
 * @Author ctzeng
 * @Date 2020/6/11 16:46
 * @Version V1.0
 **/
public class MyRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object o) {
        List<Server> servers = iLoadBalancer.getAllServers();
        for (Server server:servers) {
            System.out.println(server.getHostPort());
        }
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }

}

