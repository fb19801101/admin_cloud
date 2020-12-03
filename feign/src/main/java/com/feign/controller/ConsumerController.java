package com.feign.controller;

import com.feign.ResponseParam;
import com.feign.entity.Student;
import com.feign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-04 14:13
 */
@RestController
@RequestMapping("/consumer")
//@CrossOrigin
public class ConsumerController {
    @Resource
    private StudentService studentService;

    /**
     * 调用服务提供者
     * @return
     */
    @RequestMapping("/getMybatis")
    public Student getMybatis(@RequestParam("name") String name){
        return studentService.showStudentByName(name);
    }

    /**
     * 调用服务提供者
     * @return
     */
    @PostMapping("/postMybatis")
    public Student postMybatis(@RequestBody Map<String, Object> params){
        return studentService.showStudentByName(params.get("name").toString());
    }

    /**
     * 调用服务提供者
     * @return
     */
    @PostMapping("/postRequestParam")
    public Student postRequestParam(@ResponseParam Student student){
        return studentService.showStudentByName(student.getName());
    }

    /**
     * 调用服务提供者
     * @return
     */
    @RequestMapping("/showConsumer")
    public Student showConsumer(){
        return studentService.showStudent();
    }

    /**
     * 调用服务提供者
     * @return
     */
    @RequestMapping("/showStudents")
    public List<Student> showStudents() {
        List<Student> list = new ArrayList<>();
        list.add(studentService.showStudentByName("韩红"));
        list.add(studentService.showStudentByName("刘欢"));
        list.add(studentService.showStudentByName("李连杰"));
        list.add(studentService.showStudentByName("刘德华"));
        list.add(studentService.showStudentByName("张学友"));
        list.add(studentService.showStudentByName("郭富城"));
        list.add(studentService.showStudentByName("黎明"));
        return list;
    }
}
