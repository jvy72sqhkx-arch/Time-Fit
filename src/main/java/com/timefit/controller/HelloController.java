package com.timefit.controller;

import com.timefit.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //下面这里是我写的欢迎页啦，目前只要访问路径对了就会返回一个用户信息
    //TODO 后面这里写登录注册
    @GetMapping("/welcome")
    public User getUser() {
        User user = new User();
        user.setUserName("Jay");
        user.setPassword("123456");
        return user;
    }

}
