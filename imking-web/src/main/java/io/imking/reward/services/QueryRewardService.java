package io.imking.reward.services;

import io.imking.reward.beans.dto.RwApplyDetailDTO;
import io.imking.reward.domain.RwApplyDetail;
import io.imking.reward.domain.RwApplyDetailExample;
import io.imking.reward.domain.RwAsk;
import io.imking.reward.mapping.RwApplyDetailMapper;
import io.imking.reward.mapping.RwAskMapper;
import io.imking.utils.Constant;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class QueryRewardService {
	
	@Autowired
	private RwApplyDetailMapper rwApplyDetailMapper;
	@Autowired
	protected RwAskMapper rwAskMapper;
	
	/**
	 * 获取用户红包申请列表
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 */
	public PageInfo<RwApplyDetailDTO> getMyParticipates(Integer userId,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		pageSize = (pageSize>Constant.MAX_PAGE_SIZE?Constant.MAX_PAGE_SIZE:pageSize);
		RwApplyDetailExample example = new RwApplyDetailExample();
		example.createCriteria().andCreateByEqualTo(userId);
		example.setOrderByClause("create_time desc");
		List<RwApplyDetail> list = rwApplyDetailMapper.selectByExample(example);
		List<RwApplyDetailDTO> dtos = new LinkedList<RwApplyDetailDTO>();
		for(RwApplyDetail detail:list){
			RwApplyDetailDTO dto = new RwApplyDetailDTO();
			RwAsk ask = rwAskMapper.selectByPrimaryKey(detail.getRwAskId());
			dto.setAskContent(ask.getContent());
			dto.setContent(detail.getContent());
			dto.setCreateBy(detail.getCreateBy());
			dto.setCreateTime(detail.getCreateTime());
			dto.setTaskAmount(ask.getTaskAmount());
			dto.setTitle(ask.getTitle());
			dtos.add(dto);
		}
		return new PageInfo<RwApplyDetailDTO>(dtos);
	}
}
