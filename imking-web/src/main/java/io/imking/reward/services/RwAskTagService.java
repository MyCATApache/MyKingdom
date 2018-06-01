package io.imking.reward.services;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.dialect.db2.ast.stmt.DB2SelectQueryBlock.Isolation;

import io.imking.reward.domain.RwAskTags;
import io.imking.reward.domain.RwAskTagsExample;
import io.imking.reward.mapping.RwAskTagsMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

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
