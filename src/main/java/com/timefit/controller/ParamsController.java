package com.timefit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ParamsController {
    @RequestMapping("/params")
    public String params(@RequestParam("name")String name) {
        return "你好，"+ name + "!";
    }
}
