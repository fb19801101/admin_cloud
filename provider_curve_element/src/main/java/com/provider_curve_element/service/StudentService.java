package com.provider_curve_element.service;

import com.provider_curve_element.entity.Student;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-04 14:17
 */
public interface StudentService {
    Student getStudent();
    Student getStudentByName(String name);
}