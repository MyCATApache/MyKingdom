package io.imking.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.imking.core.services.BusinessService;
import io.imking.domain.Result;

@RestController
@RequestMapping("/biz")
public class BizController {
	
	@Autowired
	protected BusinessService businessService ;
	
	@PostMapping("/loadAll")
	@ResponseBody
	public Result<Object> loadAll(){
		Result<Object> result = new Result<>();
		
		return result.ok( businessService.selectAll() ) ;
	}
	
}
