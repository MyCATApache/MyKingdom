package io.imking.reward.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.reward.domain.RwAskTags;
import io.imking.reward.domain.RwAskTagsExample;
import io.imking.reward.mapping.RwAskTagsMapper;

@Service
@SuppressWarnings("all")
public class RwAskTagService {
	
	@Autowired
	private RwAskTagsMapper  rwAskTagsMapper;
	
	public void saveRwAskTags(RwAskTags rwAskTags) {
		if(rwAskTags.getId()== null) {
			rwAskTagsMapper.insertSelective(rwAskTags);
		}else {
			RwAskTagsExample example = new RwAskTagsExample();
			RwAskTagsExample.Criteria criteria = example.createCriteria();
	        criteria.andIdEqualTo(rwAskTags.getId());
			rwAskTagsMapper.updateByExampleSelective(rwAskTags, example);
		}
	}
	
	public List<RwAskTags> queryRwAskTagsList(String tagName) {
		RwAskTagsExample example = new RwAskTagsExample();
		RwAskTagsExample.Criteria criteria = example.createCriteria();
		criteria.andTagNameEqualTo(tagName);
		List<RwAskTags> list = rwAskTagsMapper.selectByExample(example);
		return list;
	}

	public List<RwAskTags> queryAllRwAskTags() {
		RwAskTagsExample example = new RwAskTagsExample();
		RwAskTagsExample.Criteria criteria = example.createCriteria();
		List<RwAskTags> list = rwAskTagsMapper.selectByExample(example);
		return list;
	}
}
