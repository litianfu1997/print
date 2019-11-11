package com.nnxy.print.service;

import com.nnxy.print.dao.LoginAndRegisterMapper;
import com.nnxy.print.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-11 19:09
 */
@Service
public class LoginAndRegisterService {

    @Autowired
    private LoginAndRegisterMapper loginAndRegisterMapper;
    /**
     * 用于注册
     * @param user
     */
    public boolean register(User user){

        Integer flag = loginAndRegisterMapper.insert(user);
        if (1 > flag){
            return false;
        }else {
            return true;
        }
    }

    public boolean exist(String registerNum) {
        Integer count = loginAndRegisterMapper.exist(registerNum);
        if (1 ==count){
            return true;
        }else {
            return false;
        }
    }

    public boolean login(User user) {
        Integer count = loginAndRegisterMapper.login(user);
        if (1 == count){
            return true;
        }else {
            return false;
        }
    }
}
