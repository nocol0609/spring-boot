package com.nocol.config;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:  实体类
 * @Date: Create in 2018/3/8
 * @Modified By:
 */


public class User {

    private String userName;

    private String password;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
