package io.imking.biz.reward.services;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.dialect.db2.ast.stmt.DB2SelectQueryBlock.Isolation;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.domain.RwAskTagRelationship;
import io.imking.biz.reward.domain.RwAskTagRelationshipExample;
import io.imking.biz.reward.domain.RwAskTags;
import io.imking.biz.reward.domain.RwAskTagsExample;
import io.imking.biz.reward.mapping.RwAskEvaluateMapper;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.biz.reward.mapping.RwAskQuestionMapper;
import io.imking.biz.reward.mapping.RwAskQuestionReplyMapper;
import io.imking.biz.reward.mapping.RwAskTagRelationshipMapper;
import io.imking.biz.reward.mapping.RwAskTagsMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

@Service
@SuppressWarnings("all")
public class RwAskTagRelationshipService {
	
	@Autowired
	private RwAskTagRelationshipMapper  rwAskTagRelationshipMapper;
	
	public void saveRwAskTags(List<RwAskTagRelationship> rwAskTagRelationshipList) {
		for(int i =0;i<rwAskTagRelationshipList.size();i++) {
			rwAskTagRelationshipMapper.insertSelective(rwAskTagRelationshipList.get(i));
		}
	}
	
	public List<RwAskTagRelationship> queryRwAskTagRelationshipList(Integer rwAskId){
		RwAskTagRelationshipExample example = new RwAskTagRelationshipExample();
		RwAskTagRelationshipExample.Criteria criteria = example.createCriteria();
		criteria.andRwAskIdEqualTo(rwAskId);
		List<RwAskTagRelationship> list = rwAskTagRelationshipMapper.selectByExample(example);
		return list;
	}
	
	public void deleteRwAskTagRelationshipList(Integer rwAskId){
		RwAskTagRelationshipExample example = new RwAskTagRelationshipExample();
		RwAskTagRelationshipExample.Criteria criteria = example.createCriteria();
		criteria.andRwAskIdEqualTo(rwAskId);
		rwAskTagRelationshipMapper.deleteByExample(example);
	}
	
}
