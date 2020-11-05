package com.feign.service;

import com.feign.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-04 14:21
 */
@Component
@FeignClient(value = "provider-curve-element")
//@FeignClient(value = "provider-curve-element", configuration = FeignAuthConfiguration.class)
public interface StudentService {
    @GetMapping("/student/detail")
    Student showStudent();
}
