package com.nnxy.print.util;

import lombok.Data;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-11 19:42
 */
@Data
public class Message {
    private String status;
    private String msg;
    private Object object;
    public Message(String status,String msg){
        this.status = status;
        this.msg = msg;
    }
    public Message(String status,String msg,Object object){
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

}
