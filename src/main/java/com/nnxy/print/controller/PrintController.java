package com.nnxy.print.controller;

import com.nnxy.print.entity.Print;
import com.nnxy.print.service.PrintService;
import com.nnxy.print.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-12 20:04
 */
@Controller
public class PrintController {

    @Autowired
    private PrintService printService;

    @RequestMapping("/print")
    @ResponseBody
    public Message print(@RequestBody Print print){

        System.out.println(print.toString());
        print.setGmtCreate(System.currentTimeMillis());
        print.setGmtModify(System.currentTimeMillis());
        Boolean b = printService.insert(print);
        if (b == true){
            return new Message("success","预约成功");
        }else {
            return new Message("error","预约失败，请重试");
        }
    }
}
