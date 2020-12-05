package com.consumer_curve_element;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-05 9:05
 * 如果在配置类上添加了@Configuration注解，并且该类在@ComponentScan所扫描的包中，那么该类中的配置信息就会被所有的@FeignClient共享。
 * 最佳实践是：不指定@Configuration注解（或者指定configuration，用注解忽略），而是手动：
 * @FeignClient(value = "provider-curve-element", configuration = FeignAuthConfiguration.class)
 */
@Configuration
public class ConsumerCrossOriginConfiguration implements WebMvcConfigurer {
    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin("*");
        //是否发送Cookie信息
        config.setAllowCredentials(true);
        //放行哪些原始域(请求方式)
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.addAllowedHeader("*");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

    @Bean  // 全局CORS配置
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  //项目中的所有接口都支持跨域
                        .allowedOrigins("*")  //所有地址都可以访问，也可以配置具体地址
                        .allowCredentials(true) //是否允许请求带有验证信息
                        .allowedMethods("*")  //"GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"
                        .allowedHeaders("*")  //允许的请求头
                        .maxAge(3600);  // 跨域允许时间
            }
        };
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ResponseParamHandlerMethodArgumentResolver());
    }
}