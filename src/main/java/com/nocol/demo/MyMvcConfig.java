package com.nocol.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:  增加一个拦截器，通过继承WebMvcConfigurerAdapter然后重写父类中的方法进行扩展
 * @Date: Create in 2018/3/9
 * @Modified By:
 */

@Configuration  //声明为配置，相当于xml文件
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    // 自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                System.out.println("进入自定义拦截器............");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                        Exception ex) throws Exception {
            }
        };

        /**
         * 所有请求都会进入该拦截器
         */
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }

    // 自定义消息转化器的第二种方法--重写
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("ISO-8859-1")); //乱码
        converters.add(converter);
    }
}
