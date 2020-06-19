package service_api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang.StringUtils;
import service_common.model.ResponseCode;
import service_common.model.ResponseData;
import service_common.utils.IpUtils;
import service_common.utils.JsonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * IP黑名单过滤
 * ______________________________
 *
 * @ClassName IpFilter
 * @Author ctzeng
 * @Date 2020/6/18 10:12
 * @Version V1.0
 **/
public class IpFilter extends ZuulFilter {

    private List<String> blackList = Arrays.asList("127.0.0.1");

    public IpFilter() {
        super();
    }
    
    /**
    *过滤器类型，可选值有pre，route，post，error
    *____________________________
    * @author ctzeng
    * @param
    * @return 
    * @date 2020/6/18 13:52
    */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
    *过滤器执行顺序，数值越小优先级越高
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/18 13:53
    */
    @Override
    public int filterOrder() {
        return 1;
    }
    /**
    *是否执行过滤器，true为执行，false为不执行，这个也可以利用配置中心来实现，达到动态的开启和关闭过滤器
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/18 13:54
    */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("isSuccess");
        //根据参数觉得是否执行过滤器
        return success == null ? true: Boolean.parseBoolean(success.toString());
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(requestContext.getRequest());
        System.out.println(2/0);
        //黑名单禁用
        if(StringUtils.isNotBlank(ip)&&blackList.contains(ip)){
            requestContext.setSendZuulResponse(false);
            requestContext.set("isSuccess",false);
            ResponseData responseData = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
            requestContext.setResponseBody(JsonUtils.toJson(responseData));
            requestContext.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }
        return null;
    }
}

