package com.nnxy.print.controller;

import com.nnxy.print.entity.Print;
import com.nnxy.print.service.PrintService;
import com.nnxy.print.util.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public Message print( Print print, MultipartFile file){

        String originalFilename = file.getOriginalFilename();

        try {
            if (originalFilename != null ){
                //将接收到的文件写入硬盘
                file.transferTo(new File("D:/printFile/"+originalFilename));
                System.out.println(print.toString());
                print.setGmtCreate(System.currentTimeMillis());
                print.setGmtModify(System.currentTimeMillis());

                Boolean b = printService.insert(print);
                if (b){
                    return new Message("success","上传成功");
                }
                else {
                    return new Message("error","上传失败");
                }
            }
            else {
                return new Message("error","文件为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Message("error","上传失败");
        }
    }


    @RequestMapping("/printQueue")
    public @ResponseBody List<Print> printQueue(){

        return  printService.printQueue();

    }

}
