package io.imking.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.imking.common.beans.dto.ImkUserDTO;
import io.imking.common.domain.ImkUser;
import io.imking.common.services.UserService;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

@RestController
@RequestMapping("/api/user")
public class UserController {
	 @Autowired
     private UserService userService;
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 //获取用户信息
	 @PostMapping("getUserInfo")
     public Result<ImkUserDTO> getUserInfo(Integer id){
		 Result<ImkUserDTO> result =  userService.getUserInfo(id);
         return result;
	 }
	 //用户注册
	 @PostMapping("/signup")
	    public Result signUp(@RequestBody ImkUser user) {
		 	Result result = new Result();
	        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
	        try
	        {
	        	 userService.insert(user);
	        	 
	        }catch (Exception e) {
				result.setStatus(ResultEnum.SERVER_ERROR.getCode());
				result.setDesc("用户注册失败");
				e.printStackTrace();
			}
	        result.setStatus(ResultEnum.SUCCESS.getCode());
	        result.setDesc("用户注册成功");
			return result;
	       
	    }
}
