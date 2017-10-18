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
	
}
