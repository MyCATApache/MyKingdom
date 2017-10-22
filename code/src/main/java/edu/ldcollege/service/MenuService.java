package edu.ldcollege.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.ldcollege.domain.TBMemu;
import edu.ldcollege.mapping.TBMemuMapper;

/**
 * 
 * @author Raindrops on 20171019
 *
 */
@Service
public class MenuService {
	
	@Autowired
	TBMemuMapper tbMemuMapper;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 查询用户menu
	 * @author Raindrops on 2017 10 19
	 * @param username 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo getUserMenus(String username,Integer pageNum,Integer pageSize) {
		
		if (logger.isInfoEnabled()) {
			logger.info("get UserInfo by username => [username={},pageNum={},pageSize={}]",username,pageNum,pageSize);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<TBMemu> tbMemus = tbMemuMapper.selectUserMenus(username);
		
		PageInfo userMenus = new PageInfo(tbMemus);
		
		return userMenus;
	}
	
}
