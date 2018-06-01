package io.imking.reward.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.reward.domain.RwAskTagRelationship;
import io.imking.reward.domain.RwAskTagRelationshipExample;
import io.imking.reward.mapping.RwAskTagRelationshipMapper;

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
