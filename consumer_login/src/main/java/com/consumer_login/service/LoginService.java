package com.consumer_login.service;

import com.consumer_login.entity.Login;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-06 11:40
 */
@Component
@FeignClient(value = "provider-login")
public interface LoginService {
    @PostMapping("/login/addLogin")
    int addLogin(@RequestBody Login login);

    @PostMapping("/login/setLogin")
    int setLogin(@RequestBody Login login);

    @GetMapping("/login/delLogin")
    int delLogin(@RequestParam("username") String username);

    @GetMapping("/login/getAllLogin")
    List<Login> getAllLogin();

    @GetMapping("/login/countAllLogin")
    long countAllLogin();

    @GetMapping("/login/getLoginByUsername")
    Login getLoginByUsername(@RequestParam("username") String username);

    @GetMapping("/login/getLoginByName")
    List<Login> getLoginByName(@RequestParam("name") String name);

    @GetMapping("/login/getLoginById")
    Login getLoginById(@RequestParam("id") Integer id);
}
