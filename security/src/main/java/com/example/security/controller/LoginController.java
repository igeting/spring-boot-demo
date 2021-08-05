package com.example.security.controller;

import com.example.security.service.impl.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource(name = "userDetailsService")
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/logins")
    public UserDetails logins(String username){
        return userDetailsService.loadUserByUsername(username);
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "success";
    }

    @RequestMapping("/fail")
    public ModelAndView loginFail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fail");
        return modelAndView;
    }
}
