package com.nocol.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description: 实例化Spring容器
 * @Date: Create in 2018/3/8
 * @Modified By:
 */

@Configuration //通过该注解来表明该类是一个Spring的配置文件，相当于一个xml文件

@ComponentScan(basePackages = "com.nocol.config")  //配置扫描包

@PropertySource(value = "classpath:jdbc.properties",ignoreResourceNotFound = true)  //配置外部资源文件，忽略该文件不存在

//@PropertySource(value = {"classpath:jdbc.properties","XXXXXX"},ignoreResourceNotFound = true)  //配置多个外部资源文件,忽略该文件不存在

public class SpringConfig {

    @Bean  //通过该注解表明一个Bean对象，相当于xml文件中的<bean>  --默认以方法名作为该bean的id
    public UserDao getUserDao(){
        return new UserDao();
    }

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.userName}")
    private String jdbcUserName;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean
    public DataSource dataSource(){

        BoneCPDataSource boneCPDataSource=new BoneCPDataSource();

        // 数据库驱动
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        // 数据库的用户名
        boneCPDataSource.setUsername(jdbcUserName);
        // 数据库的密码
        boneCPDataSource.setPassword(jdbcPassword);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);

        return boneCPDataSource;
    }

}
