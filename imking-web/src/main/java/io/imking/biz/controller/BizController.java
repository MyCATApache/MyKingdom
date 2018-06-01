package io.imking.biz.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.imking.biz.domain.Business;
import io.imking.biz.domain.CustInfo;
import io.imking.biz.services.BusinessService;
import io.imking.utils.Constant;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import io.imking.utils.SnowflakeWorker.SnowflakeWorkerHloder;

@RestController
@RequestMapping("/api/biz")
public class BizController {

	Logger logger = LoggerFactory.getLogger(BizController.class);

	@Autowired
	protected BusinessService businessService;

	@PostMapping("/loadAll")
	@ResponseBody
	public Result<Object> loadAll() {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS);
		return result.ok(businessService.selectAll());
	}
	
	
	@PostMapping(value="/disableBiz", produces="application/json; charset=UTF-8" )
	@ResponseBody
	public Result<Object> disableBiz(Long id){
		Result<Object> result = null ;
		if(id == null){
			result = new Result<>(ResultEnum.SERVER_ERROR , "参数传递为空") ;
			return result;
		}
		Business business = businessService.selectByPrimaryKey(id) ;
		business.setState( Constant.ZERO );
		businessService.updateByPrimaryKey( business ) ;
		return new Result<>(ResultEnum.SUCCESS , "删除成功" );
	}

	@PostMapping(value="/addBiz", produces="application/json; charset=UTF-8" )
	@ResponseBody
	public Result<Object> addBiz(@RequestBody Business business){
		Result<Object> result = null ;
		if(null == business || StringUtils.isBlank(business.getBusinessName()) ){
			result = new Result<>(ResultEnum.SERVER_ERROR , "参数传递为空") ;
			return result;
		}
		int businessNameExists = businessService.selectBusinessNameExists( business.getBusinessName() ) ;
		if(businessNameExists > 0){
			return new Result<>(ResultEnum.SERVER_ERROR , "该业务名已经存在"); 
		}
		business.setCreateTime(new Date());
		business.setState((byte)1);
		business.setId( SnowflakeWorkerHloder.nextId() );
		businessService.insert(business) ; 
		
		return new Result<>(ResultEnum.SUCCESS , "保存成功" );
	}


	@PostMapping("subscribe")
	public Result<Object> subscribe(Long[] bizid, CustInfo custInfo) {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS);
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
		Result<Object> result = new Result<>(ResultEnum.SUCCESS);
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
