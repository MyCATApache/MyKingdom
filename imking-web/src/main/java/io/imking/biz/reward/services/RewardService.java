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
import io.imking.biz.reward.mapping.RwAskEvaluateMapper;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.biz.reward.mapping.RwAskQuestionMapper;
import io.imking.biz.reward.mapping.RwAskQuestionReplyMapper;
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
}
