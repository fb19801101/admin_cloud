package com.consumer_login;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-28 20:18
 *
 * 解决浏览器出现的【已拦截跨源请求：同源策略禁止读取】问题
 */
public class ConsumerCrossOriginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Authorization, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        return true;
    }
}
