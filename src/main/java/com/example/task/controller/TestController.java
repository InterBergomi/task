package com.example.task.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.controller
 * @description:
 * @createTime: 2020-05-24 00:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public ModelAndView sayHello1() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String sayHello2() {
        //modelMap.addAttribute("message", "hello");
        return "index";
    }

}
