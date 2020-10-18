package com.restaurant.exercise.configuration;

import com.google.common.collect.Lists;
import static com.restaurant.exercise.constant.RestaurantConstants.AUTHORIZATION;
import static com.restaurant.exercise.constant.RestaurantConstants.DESCRIPTION;
import static com.restaurant.exercise.constant.RestaurantConstants.DESCRIPTION_RESTAURANT_API;
import static com.restaurant.exercise.constant.RestaurantConstants.LOGIN;
import static com.restaurant.exercise.constant.RestaurantConstants.LOGIN_API;
import static com.restaurant.exercise.constant.RestaurantConstants.PACKAGE;
import static com.restaurant.exercise.constant.RestaurantConstants.PATH_SALE;
import static com.restaurant.exercise.constant.RestaurantConstants.RESTAURANT_API;
import static com.restaurant.exercise.constant.RestaurantConstants.VERSION;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket restaurantApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(RESTAURANT_API)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE))
                .paths(PathSelectors.ant(PATH_SALE))
                .build()
                .globalOperationParameters(Collections.singletonList(new ParameterBuilder()
                        .name(AUTHORIZATION)
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .description(DESCRIPTION)
                        .required(false)
                        .build()))
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Arrays.asList(new ApiKey("JWT", AUTHORIZATION, "header")));
    }

    @Bean
    public Docket loginApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(LOGIN_API)
                .apiInfo(apiInfo())
                .select()
                .paths(regex(LOGIN))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(DESCRIPTION_RESTAURANT_API)
                .description(DESCRIPTION_RESTAURANT_API)
                .version(VERSION).build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant(PATH_SALE))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        return Lists.newArrayList(
                new SecurityReference("JWT", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")}));
    }
}
