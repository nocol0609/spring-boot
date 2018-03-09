package com.nocol.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:  XXXXApplication 作为SpringBoot的入口类
 * @Date: Create in 2018/3/8
 * @Modified By:
 */

/**
 *  @SpringBootApplication ：该注解是Spring Boot的核心注解，它其实是一个组合注解，该注解主要组合了以下注解：
 *      @SpringBootConfiguration :这是Spring Boot项目的配置注解，这也是一个组合注解。在springBoot项目中推荐使用@SpringBootConfiguration 替代@Configuration
 *      @EnableAutoConfiguration :启动自动配置，该注解会使SpringBoot 根据项目中依赖的jar包自动配置项目的配置项
 *                                   如：我们添加了spring-boot-starter-web的依赖，项目中也就会引入SpringMVC的依赖，Spring Boot就会自动配置tomcat和SpringMVC
 *
 *                                   若不需要Spring Boot自动配置，想关闭某一项的自动配置，如不想自动配置Redis，可做如下写法
 *                                   @SpringBootApplication （exclude={RedisAutoConfiguration.class}）,其他类似
 *
 *      @ComponentScan :默认扫描@SpringBootApplication 所在类的同级目录以及它的子目录
 */


@Controller     //标明这是一个SpringMvc的Controller控制器
@SpringBootApplication   //SpringBoot项目的核心注解，。主要目的是开启自动配置。
@Configuration     //配置Spring的配置类
public class HelloApplication {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Spring BiuBiu !!! 你好啊啊啊啊啊啊";
    }


    /**
     * 自定义消息转换器 ----相当于xml文件中配置----若不自定义，SpringBoot有默认消息转换器（utf-8）--内置的消息转换器取决于SpringBoot容器有没有消息转换器，没有则创建，有则不创建
     */
   /* @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));  //乱码
        return converter;
    }*/


    public static  void main(String[] args){

        /**
         * HelloApplication 要运行的XXXapplication 必须包含 @SpringBootApplication 注解
         */
        //SpringApplication.run(HelloApplication.class,args);

        SpringApplication application=new SpringApplication(HelloApplication.class);
        //application.setBannerMode(Banner.Mode.OFF); //关闭banner
        application.run(args);

    }

}
