package com.cenjil.config.start;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.util.List;

/**
 * @author CenJIl
 * @date 2019/10/16 11:25
 */
@Configuration
public class MethodConfig extends WebMvcConfigurationSupport {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
            argumentResolvers.add(getMethodResolver());
    }

    @Bean
    protected MethodResolver getMethodResolver(){
        return new MethodResolver();
    }



}
