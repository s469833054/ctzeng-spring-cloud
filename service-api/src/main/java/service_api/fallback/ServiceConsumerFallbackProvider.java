package service_api.fallback;

import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import service_common.model.ResponseCode;
import service_common.model.ResponseData;
import service_common.utils.JsonUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 回退机制
 * ______________________________
 *
 * @ClassName ServiceConsumerFallbackProvider
 * @Author ctzeng
 * @Date 2020/6/18 17:53
 * @Version V1.0
 **/
@Component
public class ServiceConsumerFallbackProvider implements FallbackProvider {

    private Logger logger = LoggerFactory.getLogger(ServiceConsumerFallbackProvider.class);

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                RequestContext ctx = RequestContext.getCurrentContext();
                Throwable throwable = ctx.getThrowable();
                if(throwable != null){
                    logger.error("",throwable.getCause());
                }
                ResponseData data = ResponseData.fail("服务内部错误", ResponseCode.SERVER_ERROR_CODE.getCode());
                return new ByteArrayInputStream(JsonUtils.toJson(data).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application","json", Charset.forName("utf-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}

