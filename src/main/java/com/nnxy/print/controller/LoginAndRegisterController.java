package com.nnxy.print.controller;

import com.nnxy.print.entity.User;
import com.nnxy.print.service.LoginAndRegisterService;
import com.nnxy.print.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-06 21:00
 */
@Controller
public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;

    @RequestMapping("/register")
    @ResponseBody
    public Message register(@RequestParam("registerNum") String registerNum, @RequestParam("name")String name
                        , @RequestParam("phone") String phone, @RequestParam("password")String password){
        //实例化user实体，我是github
        User user = new User();
        //封装user
        user.setNumber(registerNum);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        //对接收到的学号进行判断，学号是否已存在
        boolean exist = loginAndRegisterService.exist(registerNum);
        if (exist == true){
            return new Message("error","你的学号重复了，请重新输入！");
        }else {
            //调用register方法
            boolean b = loginAndRegisterService.register(user);
            if (true == b){
                return new Message("success","用户注册成功！");
            }else {
                return new Message("error","用户注册失败，请重试！");
            }
        }


    }

}
