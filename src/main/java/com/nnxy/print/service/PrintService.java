package com.nnxy.print.service;

import com.nnxy.print.dao.PrintMapper;
import com.nnxy.print.entity.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-12 20:31
 */
@Service
public class PrintService {

    @Autowired
    private PrintMapper printMapper;

    public Boolean insert(Print print) {
        Integer i = printMapper.insert(print);
        if (i < 1 ){
            return false;
        }else {
            return true;
        }

    }

    public List<Print> printQueue() {
        return printMapper.getUnPrintList();
    }
}
