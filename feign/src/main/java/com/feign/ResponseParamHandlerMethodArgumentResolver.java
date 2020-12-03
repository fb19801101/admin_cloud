package com.feign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feign.entity.Student;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-27 8:34
 *
 * 创建自定义参数解析器
 */
public class ResponseParamHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /** * 匹配下划线的格式 */
    private static Pattern pattern = Pattern.compile("_(\\w)");
    private static String underLineToCamel(String source) {
        Matcher matcher = pattern.matcher(source); StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //绑定注解标签 RequestPostParam
        return  methodParameter.hasParameterAnnotation(ResponseParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 从请求头中拿到token
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String token = request.getHeader("Authorization");
        Student student = new Student();

        if (StringUtils.isEmpty(token)) {
            JSONObject json=new JSONObject();
            json.put("name", "韩红");
            json.put("age", 40);
            return JSON.toJavaObject(json,Student.class);
        } else {
            Object object = nativeWebRequest.getAttribute("student", NativeWebRequest.SCOPE_REQUEST);
            if (object == null) {
                try {
                    BufferedReader reader = request.getReader();
                    StringBuilder sb = new StringBuilder();

                    char[] buf = new char[1024];
                    int rd;
                    while((rd = reader.read(buf)) != -1){
                        sb.append(buf, 0, rd);
                    }

                    Class<?> parameterType = methodParameter.getParameterType();
                    student = (Student)JSONObject.parseObject(sb.toString(), parameterType);
                    nativeWebRequest.setAttribute("student", sb.toString(), NativeWebRequest.SCOPE_REQUEST);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return student;
        }
    }
}
