package org.example.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: songhl
 * @datetime: 2020/5/19 14:55:34
 * @description:
 */
@RestController
public class LogAopController {

    @GetMapping(value = "/logaop/{param}")
    public String logAop(@PathVariable("param") String parmid) {
        return "Hello LogAop!!!" + parmid;
    }
}
