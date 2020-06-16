package service_consumer.utils;

import feign.Feign;

/**
 * Feign构建工具类
 * ______________________________
 *
 * @ClassName RestApiCallUtils
 * @Author ctzeng
 * @Date 2020/6/12 17:37
 * @Version V1.0
 **/
public class RestApiCallUtils {
    /**
    *获取API接口代理对象
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 17:39
    */
    public static <T>T getRestClient(Class<T> apiType,String url){
        return Feign.builder().target(apiType,url);
    }
}

