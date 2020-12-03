package com.provider_curve_element;

import java.lang.annotation.*;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-27 8:31
 *
 * 创建自定义参数解析器自定义注解
 */
@Target(ElementType.PARAMETER) //注解用于参数
@Retention(RetentionPolicy.RUNTIME) //定义该注解的生命周期
@Documented //注解信息添加在JavaDoc中
public @interface ResponseParam {
}
