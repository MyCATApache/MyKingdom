package edu.ldcollege.ctrl;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ldcollege.bean.MyOrder;

@RestController
public class RestCtrl {

	@RequestMapping(value = "/createmyorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String createMyOrder(@Valid MyOrder requestForm, BindingResult result) {
		System.out.println("received body " + requestForm);
		if (result.hasErrors()) {
			Object[] errmsg = result.getAllErrors().stream()
					.map(o -> o.getObjectName() + " " + o.getCode() + " " + o.getDefaultMessage()).toArray();
			return Arrays.toString(errmsg);
		}
		return "Success ";
	}

	@RequestMapping(value = "/createmyorder2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String createMyOrder2(@Validated({ MyOrder.ForGrounding.class }) MyOrder requestForm, BindingResult result) {
		System.out.println("received body " + requestForm);
		if (result.hasErrors()) {
			Object[] errmsg = result.getAllErrors().stream()
					.map(o -> o.getObjectName() + " " + o.getCode() + " " + o.getDefaultMessage()).toArray();
			return Arrays.toString(errmsg);
		}
		return "Success ";
	}

	@RequestMapping("/getcookie1")
	public String hello(@CookieValue(value = "mycookie1", defaultValue = "test1") String mycookie1) {

		return "mycookie1:" + mycookie1;
	}

	@RequestMapping("/setcookie1")
	public String setCookie(HttpServletResponse response) {
		Cookie foo = new Cookie("mycookie1", System.currentTimeMillis() + ""); // cookie
		foo.setMaxAge(1000); // set expire time to 1000 sec
		response.addCookie(foo); // put cookie in response
		return "Success";
	}
	
	@RequestMapping("/getsession")
	public String getSession(HttpServletRequest request) {
		HttpSession ss=request.getSession();
		
		return "Success :"+ss;
	}
}
