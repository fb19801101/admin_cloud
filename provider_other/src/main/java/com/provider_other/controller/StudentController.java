package com.provider_other.controller;

import com.provider_other.entity.Student;
import com.provider_other.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-03 21:34
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     *  获取一个学生
     * @return JSON对象
     * */
    @GetMapping(value = "/detail")
    public Student getStudent () {
        return studentService.getStudent();
    }

    /**
     *  获取一个学生
     * @return JSON对象
     * */
    @GetMapping(value = "/mybatis")
    public Student getMybatis (@RequestParam("name") String name) {
        return studentService.getStudentByName(name);
    }
}