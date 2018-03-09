package com.nocol.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:   测试方法，用于启动Spring 容器
 * @Date: Create in 2018/3/8
 * @Modified By:
 */


public class Main {
    public static void main(String[] args){

        //通过java配置来实例化Spring 容器
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

        //在Spring 容器中获取bean对象
        UserService userService=context.getBean(UserService.class);

        //调用方法查询
        List<User> userList=userService.selectUserList();
        for(User user:userList){
            System.out.println(user.getUserName()+"---"+user.getPassword()+"---"+user.getAge());
        }
    }
}
