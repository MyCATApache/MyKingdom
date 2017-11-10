package io.imking.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: 登陆相关的入口
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "SUCCESS";
    }
}
