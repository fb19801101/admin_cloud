package com.consumer_login.controller;

import com.consumer_login.entity.Login;
import com.consumer_login.entity.ResultData;
import com.consumer_login.service.LoginService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-10-30 7:56
 */
//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 用户登录
     *
     * @param login 用户对象
     * @return ResultData对象
     */
    @PostMapping(value = "/loginAction")
    public ResultData loginAction(@RequestBody Login login) {
        Login _login = loginService.getLoginByUsername(login.getUsername());

        if(_login != null) {
            if(_login.getPassword().compareTo(login.getPassword()) == 0) {
                return ResultData.success(_login);
            }
        }

        return ResultData.validateFailed();
    }

    /**
     * 插入用户对象
     *
     * @param login 用户对象
     * @return ResultData对象
     */
    @PostMapping(value = "/addLogin")
    public ResultData addLogin (@RequestBody Login login) {
        if(login == null) {
            loginService.addLogin(login);
            Login _login = loginService.getLoginByUsername(login.getUsername());
            return new ResultData(0, "添加成功", _login, 1);
        }

        return new ResultData(-1, "添加失败", login, 0);
    }

    /**
     * 更新用户对象
     *
     * @param login 用户对象
     * @return ResultData对象
     */
    @PostMapping(value = "/setLogin")
    public ResultData setLogin (@RequestBody Login login) {
        if(login != null) {
            loginService.setLogin(login);
            Login _login = loginService.getLoginByUsername(login.getUsername());
            return new ResultData(0, "更新成功", _login, 1);
        }

        return new ResultData(-1, "更新失败", login, 0);
    }

    /**
     * 删除用户对象
     *
     * @param username 用户名
     * @return ResultData对象
     */
    @GetMapping(value = "/delLogin")
    public ResultData delLogin (@RequestParam("username") String username) {
        Login login = loginService.getLoginByUsername(username);

        if(login != null) {
            loginService.delLogin(username);
            return new ResultData(0, "删除成功", login, 1);
        }

        return new ResultData(-1, "删除失败", null, 0);
    }

    /**
     *  获取所有用户对象
     * @return 用户对象列表
     * */
    @GetMapping(value = "/getAllLogin")
    public ResultData getAllLogin () {
        List list = loginService.getAllLogin();
        long count = loginService.countAllLogin();

        if(list != null) {
            return new ResultData(0, "获取成功", list, count);
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    /**
     *  获取用户数量
     * @return ResultData对象
     * */
    @GetMapping(value = "/countAllLogin")
    public ResultData countAllLogin () {
        Long count = loginService.countAllLogin();

        if(count != null) {
            return new ResultData(0, "获取成功", count, 1);
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    /**
     * 获取用户对象,通过用户名
     *
     * @param username 用户名
     * @return ResultData对象
     */
    @GetMapping(value = "/getLoginByUsername")
    public ResultData getLoginByUsername (@RequestParam("username") String username) {
        Login login = loginService.getLoginByUsername(username);

        if(login != null) {
            return new ResultData(0, "获取成功", login, 1);
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    /**
     * 获取用户对象,通过用户类别
     *
     * @param name 用户类别
     * @return ResultData对象
     */
    @GetMapping(value = "/getLoginByName")
    public ResultData getLoginByName (@RequestParam("name") String name) {
        List list = loginService.getLoginByName(name);

        if(list != null) {
            return new ResultData(0, "获取成功", list, list.size());
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    /**
     * 获取用户对象,通过用户ID
     *
     * @param id 用户id
     * @return ResultData对象
     */
    @GetMapping(value = "/getLoginById")
    public ResultData getLoginById (@RequestParam("id") Integer id) {
        Login login = loginService.getLoginById(id);

        if(login != null) {
            return new ResultData(0, "获取成功", login, 1);
        }

        return new ResultData(-1, "获取失败", null, 0);
    }
}