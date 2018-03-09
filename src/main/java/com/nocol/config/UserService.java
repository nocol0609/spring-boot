package com.nocol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company:保保网络科技
 * @Author:nocol
 * @Description:  实现user数据业务操作作
 * @Date: Create in 2018/3/8
 * @Modified By:
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> selectUserList(){
        return  userDao.selectUserList();
    }
}
