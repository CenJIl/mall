package com.cenjil.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author CenJIl
 * @date 2019/9/4 18:07
 */
@Configuration
public class JsonConfig {
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();

        jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonHttpMessageConverter.setFastJsonConfig(jsonConfig);

        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}
