package com.nnxy.print.dao;

import com.nnxy.print.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2019-11-11 19:11
 */
@Mapper
public interface LoginAndRegisterMapper {

    /**
     * 插入一个用户到user表
     * @param user
     * @return
     */
    @Insert("insert into user(number,name,phone,password) values(#{number},#{name},#{phone},#{password})")
    Integer insert(User user);

    @Select("select count(1) from user where number = #{registerNum}")
    Integer exist(@Param("registerNum") String registerNum);

    @Select("select count(1) from user where number = #{number} and password = #{password}")
    Integer login(User user);
}
