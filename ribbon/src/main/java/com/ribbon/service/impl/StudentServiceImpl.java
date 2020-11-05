package com.ribbon.service.impl;

import com.ribbon.entity.Student;
import com.ribbon.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @Override
    public Student showStudent() {
        /*
         * 通过Ribbon 发送服务调用 用的是RestTemplate
         * RestTemplate 本身没有负载均衡的能力
         * 使用restTemplate基于http的restful方式在服务之间通信
         * 方法前缀get即表示get请求，第一个参数即为url，这里直接使用对应服务名替代，返回的Object类型会根据第二个参数进行自动转换
         * 注意：RestTemplate请求地址中写的不是 ip+端口号 而是被调用服务的服务名称
         * 开启@LoadBalanced后，不能直接访问提供方的具体主机名和端口号，否则报错 java.lang.IllegalStateException: No instances available for localhost
         * 服务名不要使用下划线，否则报错 Request URI does not contain a valid hostname: http://service_provider/user/42
         */

        //查询到服务提供者的数据
        return restTemplate.getForObject("http://provider/student/detail", Student.class);
    }
}
