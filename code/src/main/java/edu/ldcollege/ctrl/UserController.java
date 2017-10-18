package edu.ldcollege.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ldcollege.domain.TBUser;
import edu.ldcollege.service.UserService;
import edu.ldcollege.util.JwtUtils;
import edu.ldcollege.util.PBEUtils;
import edu.ldcollege.util.RestResult;
import edu.ldcollege.util.RestStatus;

/**
 * 用户
 * @author Raindrops on 20171019
 *
 */
@RequestMapping("/user")
@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping("info")
	@ResponseBody
	public RestResult userInfo(@RequestHeader("token")String token) {
		if (logger.isInfoEnabled()) {
			logger.info("GET /user/info 获取用户信息  [token={}]",token);
		}
		String username = JwtUtils.verifyJWT(token);
		TBUser tbUser = userService.getUserInfo(username);
		return new RestResult(RestStatus.SUCCEED, tbUser);
	}
	
	
	
}
