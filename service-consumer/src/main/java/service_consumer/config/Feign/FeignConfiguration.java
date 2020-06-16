package service_consumer.config.Feign;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Feign日志配置
 * 日志等级4种：
 * NONE:不输出日志
 * BASIC:只输出请求方法和URL和响应的状态码以及接口执行的时间
 * HEADERS:将BASIC信息和请求头信息输出
 * FULL:输出完整的请求信息
 * ______________________________
 *
 * @ClassName FeignConfiguration
 * @Author ctzeng
 * @Date 2020/6/12 14:43
 * @Version V1.0
 **/
public class FeignConfiguration {
    /**
    *日志级别
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 14:45
    */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
    /**
    *契约配置 修改为默认配置之后Feign不支持SpringMVC注解 先注释
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 15:11
    */
    /*@Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }*/
    /**
    *Feign Basic认证配置
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 15:17
    */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
        //自定义拦截器
        //return new FeignBasicAuthRequestInterceptor();
    }
    
    /**
    *超时时间配置
     * 第一个参数是连接超时时间（ms），默认值是10x1000；第二个是取超时时间（ms）,默认值为60x1000
    *____________________________
    * @author ctzeng
    * @param
    * @return 
    * @date 2020/6/12 15:33
    */
    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
    /**
    *编码器解码器配置 先注释
    *____________________________
    * @author ctzeng
    * @param
    * @return
    * @date 2020/6/12 17:22
    */
    /*@Bean
    public Decoder decoder(){
        return new MyDecoder();
    }
    @Bean
    public Encoder encoder(){
        return new MyEncoder();
    }*/
}

