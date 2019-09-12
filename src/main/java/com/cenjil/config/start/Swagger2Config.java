package com.cenjil.config.start;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @author CenJIl
 * @date 2019/9/3 10:42
 * swagger接口文档生成配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket swagger2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfo(
                                "API文档",
                                "",
                                "1.0",
                                "",
                                new Contact("", "", ""),
                                "",
                                "",
                                new ArrayList<VendorExtension>()
                        )
                )
                .groupName("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cenjil.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
