package com.provider_other.mapper;

import com.provider_other.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * CurveElementMapper继承基类
 */
@Mapper
public interface StudentMapper {
    @Delete("delete from tb_student")
    void clearStudent();

    Student selectByName(String name);
}