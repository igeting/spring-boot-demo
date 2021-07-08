package com.example.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class TestController {

    @RequestMapping(value = "/test")
    public String test() {
        log.info("/api/test");
        return "success";
    }

    @RequestMapping(value = "/info")
    public String info() {
        log.info("/api/info");
        throw new NullPointerException("TestController have exception");
    }

}
