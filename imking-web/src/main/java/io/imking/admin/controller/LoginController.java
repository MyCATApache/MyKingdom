package io.imking.admin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.imking.core.domain.Result;
import io.imking.core.domain.ResultEnum;

/**
 * Desc: 登陆相关的入口
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
	@RequestMapping("/login")
    public String login() {
        return "SUCCESS";
    }
    
    @RequestMapping("/loginSuccess")
	public Result<Authentication> loginSuccess(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
		 
		 return new Result<>(ResultEnum.SUCCESS , authentication) ;
	}
}
