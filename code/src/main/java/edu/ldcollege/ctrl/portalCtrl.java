package edu.ldcollege.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class portalCtrl {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/api/getAllKings", method = RequestMethod.GET)
	public String getAllKings(String userId) {
		logger.info("getAllKings " + userId);
		try {
			return "Success";
		} catch (Exception e) {
			return "失败:" + e;
		}
	}
	
	@RequestMapping(value = "/api/getMyClasses", method = RequestMethod.GET)
	public String getMyClasses(String userId) {
		logger.info("getMyClasses " + userId);
		try {
			return "Success";
		} catch (Exception e) {
			return "失败:" + e;
		}
	}
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public String login(String userId,String password) {
		logger.info("login " + userId);
		try {
			return "Success";
		} catch (Exception e) {
			return "失败:" + e;
		}
	}
	
	@RequestMapping(value = "/api/submitHomework", method = RequestMethod.POST)
	public String SubmitHomework(Object obj) {
		logger.info("submitHomework ");
		try {
			return "Success";
		} catch (Exception e) {
			return "失败:" + e;
		}
	}
	
	@RequestMapping(value = "/api/markHomework", method = RequestMethod.POST)
	public String gradeHomework(String userId) {
		logger.info("markHomework " + userId);
		try {
			return "Success";
		} catch (Exception e) {
			return "失败:" + e;
		}
	}
}
