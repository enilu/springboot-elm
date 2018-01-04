package cn.enilu.elm.api.conf;

import cn.enilu.elm.api.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Created  on 2017/12/29 0029.
 *
 * @author zt
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(AuthFilter());
        registration.setOrder(1);
        return registration;
    }

    @Bean()
    public Filter AuthFilter() {
        return new SessionFilter();
    }
}
