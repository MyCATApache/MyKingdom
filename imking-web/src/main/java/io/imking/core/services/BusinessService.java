package io.imking.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.biz.domain.Business;
import io.imking.biz.mapping.BusinessMapper;

@Service
public class BusinessService {
	
	@Autowired
	protected BusinessMapper businessMapper;
	
	public int deleteByPrimaryKey(Long id){
		return businessMapper.deleteByPrimaryKey(id) ;
	}
	
	public int insert(Business record){
		return businessMapper.insert(record) ;
	}
	
	public int insertSelective(Business record){
		return businessMapper.insertSelective(record) ;
	}
	
	
	public  Business selectByPrimaryKey(Long id){
		return businessMapper.selectByPrimaryKey(id) ;
	}
	
	public int updateByPrimaryKeySelective(Business record){
		return businessMapper.updateByPrimaryKeySelective(record) ;
	}
	
	public int updateByPrimaryKey(Business record){
		return businessMapper.updateByPrimaryKey(record) ;
	}
	
	public List<Business> selectAll(){
		return businessMapper.selectAll() ;
	}
	
}
