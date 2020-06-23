package service_consumer.filter;

import brave.Span;
import brave.Tracer;
import brave.http.HttpServerResponse;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TracingFilter 是负责处理请求和响应的组件，我们可以通过注册自定义的 TracingFilter 实例来实现一些扩展性的需求。
 * 下面给大家演示下如何给请求添加自定义的标记以及将请求 ID 添加到响应头返回给客户端。
 * ______________________________
 *
 * @ClassName TracingFilter
 * @Author ctzeng
 * @Date 2020/6/23 15:39
 * @Version V1.0
 **/
//@Component
//@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER+1)
public class TracingFilter extends GenericFilterBean {

    private final Tracer tracer;

    public TracingFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Span span = this.tracer.currentSpan();
        if(span !=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        ((HttpServletResponse)servletResponse).addHeader("ZIPKIN-TRACE-ID",span.context().traceIdString());
        span.tag("ctzeng", "service-consumer");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

