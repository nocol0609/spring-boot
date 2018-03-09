package com.nocol.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:  模拟数据库交互
 * @Date: Create in 2018/3/8
 * @Modified By:
 */


public class UserDao {

    public List<User> selectUserList(){

        List<User> userList=new ArrayList<User>();

        for(int i=0;i<10;i++){

            User user=new User();
            user.setUserName("userName_"+i);
            user.setPassword("passWord_"+i);
            user.setAge(i+1);
            userList.add(user);
        }
        return userList;
    }

}
