package com.ac.learn.config.swagger;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  swagger ui
 * @author anchao
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Value("${spring.profiles.active}")
    private String profile;


    @Bean
    public Docket createRestApi() {
        boolean mark = !(StringUtils.isNotBlank(profile) && profile.contains("prd"));
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("leader")
                .contact(new Contact("anchao","",""))
                .description("api service")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(mark)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ac.leader"))
                .paths(PathSelectors.any())
                .build();
    }
}
