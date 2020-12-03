package com.jsp_feign.controller;

import com.jsp_feign.entity.Student;
import com.jsp_feign.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    public static List<File> getFileList(String strPath) {
        List<File> filelist = new ArrayList<>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath()); //遍历子文件夹里面的东西
                } else if (fileName.endsWith("exe")) { // 以***结尾的文件
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                } else {
                    filelist.add(files[i]);
                    continue;
                }
            }
        }
        return filelist;
    }

    @RequestMapping("/carousel")
    public ModelAndView home_carousel(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/")+"res/img/carousel";
        List<File> listFile = getFileList(path);
        HashMap mapMsg = new HashMap();
        List<String> list = new ArrayList<>();
        for(File file : listFile) {
            list.add(file.getName());
        }

        mapMsg.put("list", list);
        mapMsg.put("size", list.size());
        return new ModelAndView("carousel", "message", mapMsg);
    }
}
