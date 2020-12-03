package com.provider_login.mapper;

import com.provider_login.entity.Login;
import com.provider_login.entity.LoginExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * LoginMapper继承基类
 */
@Mapper
public interface LoginMapper extends MyBatisBaseMapper<Login, Integer, LoginExample> {
    @Select("select * from tb_login where name = #{name}")
    List<Login> selectByName(@Param("name") String name);

    @Select("select * from tb_login where username = #{username}")
    Login selectByUsername(@Param("username") String username);
}