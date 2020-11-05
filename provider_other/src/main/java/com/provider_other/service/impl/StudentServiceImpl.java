package com.provider_other.service.impl;

import com.provider_other.entity.Student;
import com.provider_other.mapper.StudentMapper;
import com.provider_other.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-04 14:18
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student getStudent () {
        Student student = new Student();
        //可以看到，我们没有在实体类写get和set方法，但是我们依然可以调用这些方法
        //这就是Lombok插件的好处，只需要在实体类加一个@Data注解
        student.setName("李四");
        student.setAge(58);
        return student;
    }

    @Override
    public Student getStudentByName (String name) {
        return studentMapper.selectByName(name);
    }
}
