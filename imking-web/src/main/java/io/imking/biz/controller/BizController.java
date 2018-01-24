package io.imking.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.imking.biz.domain.CustInfo;
import io.imking.core.services.BusinessService;
import io.imking.domain.Result;

@RestController
@RequestMapping("/api/biz")
public class BizController {

	Logger logger = LoggerFactory.getLogger(BizController.class);

	@Autowired
	protected BusinessService businessService;

	@PostMapping("/loadAll")
	@ResponseBody
	public Result<Object> loadAll() {
		Result<Object> result = new Result<>();
		return result.ok(businessService.selectAll());
	}

	@PostMapping("subscribe")
	public Result<Object> subscribe(Long[] bizid, CustInfo custInfo) {
		Result<Object> result = new Result<>();
		try {
			businessService.insertCustInfo(custInfo, bizid);
			result.ok( String.valueOf(custInfo.getId()) ) ;
		} catch (Exception e) {
			result.error("预约失败");
			logger.error("/biz/subscribe", e);
		}
		return result;
	}
	
	@PostMapping("confirm")
	public Result<Object> confirm(String cstId,String ccTime) {
		Result<Object> result = new Result<>();
		try {
			CustInfo custInfo = businessService.selectCustInfo( Long.valueOf(cstId) ) ;
			custInfo.setCcTime(ccTime);
			businessService.updateCustInfo(custInfo) ;
			result.ok("确认成功");
		} catch (Exception e) {
			result.error("确认失败");
			logger.error("/biz/subscribe", e);
		}
		return result;
	}
}
