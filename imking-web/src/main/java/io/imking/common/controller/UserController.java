package io.imking.common.controller;

import io.imking.common.services.MailService;
import io.imking.utils.GenRandom;
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

	@Autowired
	MailService mailService;
	 
	 //获取用户信息
	 @PostMapping("getUserInfo")
     public Result<ImkUserDTO> getUserInfo(Integer id){
		 Result<ImkUserDTO> result = new Result<ImkUserDTO>();
		 ImkUserDTO user = userService.getUserInfo(id);
		 if(user != null){
			 result.setData(user);
		 }
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


	/**
	 * 找回密码
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 * @author zhanyingda
	 */
	@PostMapping("/findPassward")
	public Result findPassward(Integer id) {
	 	//TODO 验证验证码
		Result result = new Result();
		try{
			//获取邮箱
			ImkUserDTO userDTO = userService.getUserInfo(id);
			//随机生成密码
			String passward = GenRandom.genRandomNum(6);
			//更新密码
			ImkUser user = new ImkUser();
			user.setId(id);
			user.setPwd(bCryptPasswordEncoder.encode(passward));
			userService.updateByPrimaryKeySelective(user);
			//发送邮件
			mailService.sendSimpleMail(userDTO.getEmail(),"mykingdom密码找回","您的密码已重置为:" + passward);
			result.ok("密码已发送到你邮箱");
		}catch (Exception e) {
			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("找回密码失败");
			e.printStackTrace();
		}
		return result;
	}
}
