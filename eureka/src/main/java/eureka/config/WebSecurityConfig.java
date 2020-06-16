package eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 关闭csrf spring2.x版本的security默认启用了csrf检验
 * ______________________________
 *
 * @ClassName WebSecurityConfig
 * @Author ctzeng
 * @Date 2020/6/5 14:17
 * @Version V1.0
 **/
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//关闭csrf
        super.configure(http);
    }
}

