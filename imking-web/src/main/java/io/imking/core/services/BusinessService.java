package io.imking.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import io.imking.biz.domain.Business;
import io.imking.biz.domain.CustBusiness;
import io.imking.biz.domain.CustInfo;
import io.imking.biz.mapping.BusinessMapper;
import io.imking.biz.mapping.CustBusinessMapper;
import io.imking.biz.mapping.CustInfoMapper;
import io.imking.domain.SnowflakeWorker.SnowflakeWorkerHloder;

@Service
public class BusinessService {

	@Autowired
	protected BusinessMapper businessMapper;

	@Autowired
	protected CustInfoMapper custInfoMapper;

	@Autowired
	protected CustBusinessMapper custBusinessMapper;

	@Transactional(isolation = Isolation.DEFAULT)
	public boolean insertCustInfo(CustInfo custInfo, Long[] bizIds) {

		custInfo.setId(SnowflakeWorkerHloder.nextId());
		custInfoMapper.insert(custInfo);
		for (Long bizId : bizIds) {
			CustBusiness business = new CustBusiness();
			business.setCustId(custInfo.getId());
			business.setBizId(bizId);
			business.setId(SnowflakeWorkerHloder.nextId());
			custBusinessMapper.insert(business);
		}
		
		return true;
	}

	public int deleteByPrimaryKey(Long id) {
		return businessMapper.deleteByPrimaryKey(id);
	}

	public int insert(Business record) {
		return businessMapper.insert(record);
	}

	public int insertSelective(Business record) {
		return businessMapper.insertSelective(record);
	}

	public Business selectByPrimaryKey(Long id) {
		return businessMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Business record) {
		return businessMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Business record) {
		return businessMapper.updateByPrimaryKey(record);
	}

	public List<Business> selectAll() {
		return businessMapper.selectAll();
	}

}
