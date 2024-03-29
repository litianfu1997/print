package com.nnxy.print.dao;

import com.nnxy.print.entity.Print;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-12 20:31
 */
@Mapper
public interface PrintMapper {

    @Insert("insert into print(number,size,printStyle,printColor,note,gmtCreate,gmtModify) " +
            "values(#{number},#{size},#{printStyle},#{printColor},#{note},#{gmtCreate},#{gmtModify})")
    Integer insert(Print print);

    @Select("select * from print where flag = 0 order by gmtModify ")
    List<Print> getUnPrintList();
}
