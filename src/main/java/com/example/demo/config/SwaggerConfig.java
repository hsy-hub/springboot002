package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration//说明是一个配置类
@EnableSwagger2//支持swagger2
public class SwaggerConfig {
    /**
     * 创建BeanApi
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,
     用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        //添加header参数
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("user token")//添加header注入参数
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();//header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());//根据每个方法名也知道当前方法在设置什么参数


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))//扫描Api包重点 对指定 报下的偶生成文档
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);//添加全局的操作参数配置
    }
    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot-Swagger")//api的标日
                .description("一般常用api信息")//api描述
                .termsOfServiceUrl("https://www.baidu.com/")//服务地址
                .contact(new Contact("cqc", "https://www.baidu.com/", "leomple@163.com"))//联系信息
                .version("1.0")
                .build();
    }


}
