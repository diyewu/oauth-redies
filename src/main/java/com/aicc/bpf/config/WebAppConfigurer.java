package com.aicc.bpf.config;

import com.aicc.bpf.interceptor.ClientSecurityInterceptor;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Autowired ClientSecurityInterceptor clientSecurityInterceptor;

    @Autowired
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(clientSecurityInterceptor)
                .excludePathPatterns("/auth/user/login","/demo/**","/error")
//                .excludePathPatterns("/authlogin/**")
//                .excludePathPatterns()
                .addPathPatterns("/**")
        ;
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")//拦截所有的url
//                .allowedOrigins("*")// 放行哪些原始域，比如"http://domain1.com,https://domain2.com"
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // 放行哪些原始域(请求方式)
//                .allowedHeaders("*");// 放行哪些原始域(头部信息)
//    }

    /*@Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }*/

    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.set(0,new MappingJackson2HttpMessageConverter());
    }*/

    /**
     * 配置消息转换器--这里我用的是alibaba 开源的 fastjson
     * @param converters
     */
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
                ,SerializerFeature.WriteMapNullValue
                ,SerializerFeature.WriteNullStringAsEmpty
                ,SerializerFeature.DisableCircularReferenceDetect
                ,SerializerFeature.WriteNullListAsEmpty
                ,SerializerFeature.WriteDateUseDateFormat
                                                );
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);
    }*/

}
