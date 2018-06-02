package io.imking.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.imking.common.domain.ImkUser;
import io.imking.common.services.UserService;
import io.imking.utils.Result;

@RestController
@RequestMapping("/api/user")
public class UserController {
	 @Autowired
     private UserService userService;
	 
	 
	 
	 @PostMapping("getUserInfo")
     public Result<ImkUser> getUserInfo(Integer id){
		 Result<ImkUser> result =  userService.getUserInfo(id);
         return result;
	 }

}
