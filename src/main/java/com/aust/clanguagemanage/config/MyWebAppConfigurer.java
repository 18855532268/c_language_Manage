package com.aust.clanguagemanage.config;//package com.aust.clanguage.base.config;
//
//import com.aust.clanguage.base.interceptor.ManagerAuthInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class MyWebAppConfigurer implements WebMvcConfigurer {
//
//    @Bean
//    public ManagerAuthInterceptor getUserAuthInterceptor() {
//        return new ManagerAuthInterceptor();
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        // 注册JsonRequest的参数分解器
//        argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
//        registry.addInterceptor(getUserAuthInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
//    }
//
//    private ArrayList<String> getExcludeCommonPathPatterns() {
//        ArrayList<String> list = new ArrayList<>();
//        String[] urls = {
//                "/login/**",
//                "/upload/audio",
//                "/upload/video",
//                "/upload/test/**"
//        };
//        Collections.addAll(list, urls);
//        return list;
//    }
//}