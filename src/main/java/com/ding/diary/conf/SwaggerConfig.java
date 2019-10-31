package com.ding.diary.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @description: SwaggerConfig
 * @author: ding
 * @date: 2019/10/18 14:41
 * @version: 1.0
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("日记").build();
    }

    @Bean
    public Docket api(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        ArrayList<Parameter> list = new ArrayList<>();
        parameterBuilder.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        list.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).globalOperationParameters(list);
    }

}
