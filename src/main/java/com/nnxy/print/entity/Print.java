package com.nnxy.print.entity;

import lombok.Data;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-12 20:06
 */
@Data
public class Print {
    /**
     * 预约打印信息的创建者
     */
    private String number;

    private String size;
    /**
     * 单双面打印
     */
    private String printStyle;
    /**
     * 黑白彩印
     */
    private String printColor;
    private String note;
    private Long gmtCreate;
    private Long gmtModify;
    private Integer flag;
}
