package io.imking.biz.reward.controller;

import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class RewardController {

    @RequestMapping("/loginSuccess")
    public Result<String> loginSuccess(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;

        return new Result<>(ResultEnum.SUCCESS , authentication.getName()) ;
    }

    @RequestMapping("/loginFailure")
    public Result<String> loginFailure(){

        return new Result<>(ResultEnum.SERVER_ERROR , "账号或密码错误" ) ;
    }
}
