package io.imking.core.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.header.HeaderWriter;

public class AccessControlHeaderWriter implements HeaderWriter {

	@Override
	public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization, _token");
		response.setHeader("Access-Control-Allow-Credentials", "true"); 
	}

}
