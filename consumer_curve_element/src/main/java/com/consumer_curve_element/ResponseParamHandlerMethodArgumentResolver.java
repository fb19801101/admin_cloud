package com.consumer_curve_element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.consumer_curve_element.entity.ResultData;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Parameter;
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

        if (StringUtils.isEmpty(token)) {
            JSONObject json=new JSONObject();
            json.put("code", -1);
            json.put("message", "错误参数传递");
            json.put("data", null);
            json.put("count", 0);
            return JSON.toJavaObject(json, ResultData.class);
        } else {
            Object object = nativeWebRequest.getAttribute("Authorization", NativeWebRequest.SCOPE_REQUEST);
            if(object == null) {
                try {
                    BufferedReader reader = request.getReader();
                    StringBuilder sb = new StringBuilder();

                    char[] buf = new char[1024];
                    int rd;
                    while((rd = reader.read(buf)) != -1){
                        sb.append(buf, 0, rd);
                    }

                    Parameter parameter = methodParameter.getParameter();
                    JSONObject json = JSON.parseObject(sb.toString());
                    if(json.size() == 1) {
                        JSONObject obj = json.getJSONObject(parameter.getName());
                        object = obj.toJavaObject(parameter.getType());
                    } else {
                        object = json;
                    }
                    nativeWebRequest.setAttribute(parameter.getType().getName(), sb.toString(), NativeWebRequest.SCOPE_REQUEST);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return object;
        }
    }
}
