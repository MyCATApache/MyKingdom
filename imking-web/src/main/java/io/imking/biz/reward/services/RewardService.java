package io.imking.biz.reward.services;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.imking.biz.reward.domain.RwAnswerExample;
import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskEvaluateExample;
import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.domain.RwAskQuestionExample;
import io.imking.biz.reward.domain.RwCommentExample;
import io.imking.biz.reward.dto.RwDetailDto;
import io.imking.biz.reward.mapping.RwAnswerMapper;
import io.imking.biz.reward.mapping.RwAskEvaluateMapper;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.biz.reward.mapping.RwAskQuestionMapper;
import io.imking.biz.reward.mapping.RwAskQuestionReplyMapper;
import io.imking.biz.reward.mapping.RwCommentMapper;
import io.imking.biz.reward.status.RewardStatusEnum;
import io.imking.core.domain.User;
import io.imking.core.mapping.UserMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

@Service
@SuppressWarnings("all")
public class RewardService {
	@Autowired
	protected RwAskMapper rwAskMapper;
	@Autowired
	protected RwAskQuestionMapper rwAskQuestionMapper;
	@Autowired
	protected RwAskQuestionReplyMapper rwAskQuestionReplyMapper;
	@Autowired
	protected RwAskEvaluateMapper rwAskEvaluateMapper;
	@Autowired
	protected RwCommentMapper rwCommentMapper;
	@Autowired
	protected UserMapper userMapper;
	@Autowired
	protected RwAnswerMapper rwAnswerMapper;
	/**
	 * table切换红包任务列表
	 * @return Result
	 * @author 天道
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true, timeout = 2000)
	public Result<Map<String, Object>> tableRwAsks() {
		Result result = new Result();
		try {
			WeakHashMap responseResult = new WeakHashMap();
			List<RwAsk> rwAsks = rwAskMapper.selectByExample(null);
			List<RwAsk> questionRelationRwAsks = rwAskQuestionMapper.selectRelationByExample(null);
			List<RwAsk> questionReplyRelationRwAsks = rwAskQuestionReplyMapper.selectRelationByExample(null);
			List<RwAsk> evaluateRelationRwAsks = rwAskEvaluateMapper.selectRelationByExample(null);
			responseResult.put("all", rwAsks);
			responseResult.put("question", questionRelationRwAsks);
			responseResult.put("questionReply", questionReplyRelationRwAsks);
			responseResult.put("evaluate", evaluateRelationRwAsks);
			result.setData(responseResult);
			result.setDesc("查询成功");
			result.setStatus(ResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("table列表查询失败");
		}
		return result;
	}
	
	public Result<?> createRw(RwAsk rwAsk) {
		int count = rwAskMapper.insertSelective(rwAsk);
		if (count < 1) {
			return new Result<>(ResultEnum.SERVER_ERROR, "创建红包异常");
		}
		// 返回ID
		int rwId = rwAskMapper.selectLastInsert();
		return new Result<>(ResultEnum.SUCCESS, rwId);
	}
	
	public PageInfo<RwDetailDto> searchRWByTitle(String title,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		RwAskExample example = new RwAskExample();
		RwAnswerExample rwAnswerExample = new RwAnswerExample();
		RwCommentExample rwCommentExample = new RwCommentExample();
		RwAskQuestionExample rwAskQuestionExample = new RwAskQuestionExample();
		example.createCriteria().andStatusEqualTo(RewardStatusEnum.OPEN.getCode()).andTitleLike("%"+title+"%");
		example.setOrderByClause("create_time desc");
		List<RwAsk> rwAsks = rwAskMapper.selectByExample(example);
		List<RwDetailDto> rwDetailDtos = rwAsks.stream().map((rwAsk)->{
			RwDetailDto dto = new RwDetailDto();
			dto.setCreateTime(rwAsk.getCreateTime());
			dto.setTaskAmount(rwAsk.getTaskAmount());
			dto.setId(rwAsk.getId());
			dto.setTitle(rwAsk.getTitle());
			dto.setType(rwAsk.getType());
			User user = userMapper.selectNameByPrimaryKey(rwAsk.getCreateBy().longValue());
			dto.setNickname(user.getNickname());
			//rwAsk.get
			rwAnswerExample
				.createCriteria()
				.andRwAskIdEqualTo(rwAsk.getId());
			long answerCount = rwAnswerMapper.countByExample(rwAnswerExample);
			dto.setAnswerCount(answerCount);
			rwCommentExample
				.createCriteria()
				.andRwAskIdEqualTo(rwAsk.getId());
			long rwCommentCount = rwCommentMapper.countByExample(rwCommentExample);
			dto.setCommentCount(rwCommentCount);
			rwAskQuestionExample
				.createCriteria()
				.andRwAskIdEqualTo(rwAsk.getId());
			long questionCount = rwAskQuestionMapper.countByExample(rwAskQuestionExample);
			dto.setQuestionCount(questionCount);
			return dto;
		}).collect(Collectors.toList());
		return new PageInfo<RwDetailDto>(rwDetailDtos);
	}
	
}
