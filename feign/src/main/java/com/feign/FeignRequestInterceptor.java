package com.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-05 9:05
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // TODO Auto-generated method stub, cm9vdDpyb290 表示通过 BASE64 加密过的账号密码
        template.header("Authorization", "Basic cm9vdDpyb290");
    }
}