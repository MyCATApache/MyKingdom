package io.imking.reward.services ;

import java.util.Date;
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

import io.imking.common.beans.dto.ImkUserDTO;
import io.imking.common.mapping.ImkUserMapper;
import io.imking.reward.beans.dto.RwDetailDto;
import io.imking.reward.beans.enums.CommentTypeEnum;
import io.imking.reward.beans.enums.RewardStatusEnum;
import io.imking.reward.domain.RwAnswer;
import io.imking.reward.domain.RwAnswerExample;
import io.imking.reward.domain.RwAsk;
import io.imking.reward.domain.RwAskExample;
import io.imking.reward.domain.RwAskQuestion;
import io.imking.reward.domain.RwAskQuestionExample;
import io.imking.reward.domain.RwComment;
import io.imking.reward.domain.RwCommentExample;
import io.imking.reward.mapping.RwAnswerMapper;
import io.imking.reward.mapping.RwAskEvaluateMapper;
import io.imking.reward.mapping.RwAskMapper;
import io.imking.reward.mapping.RwAskQuestionMapper;
import io.imking.reward.mapping.RwAskQuestionReplyMapper;
import io.imking.reward.mapping.RwCommentMapper;
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
	protected ImkUserMapper userMapper;
	@Autowired
	protected RwAnswerMapper rwAnswerMapper;
	/**
	 * table切换红包任务列表
	 * @return Result
	 * @author 天道
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true, timeout = 2000)
	public Result<Map<String, Object>> getRwAskDetail() {
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
//			User user = userMapper.selectNameByPrimaryKey(rwAsk.getCreateBy().longValue());
//			dto.setNickname(user.getNickname());
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
	
	/**
	 * 回答问题(抢红包)
	 * 
	 * @param rwAsk
	 *            红包任务
	 * @param rwAnswerContent
	 *            红包任务回答内容
	 * @return Result<String>
	 * @author 天道
	 */
	public Result<String> submitAnswer(RwAsk rwAsk, String rwAnswerContent) {
		Result<String> result = new Result<String>();
		try {
			if ((null != rwAsk.getId() && rwAsk.getId() > 0)
					&& (null != rwAsk.getCurrentAnswerUserId() && rwAsk.getCurrentAnswerUserId() > 0)) {
				ImkUserDTO user = userMapper.selectByPrimaryKey((rwAsk.getCurrentAnswerUserId()));
				if (null != user) {
					rwAsk = rwAskMapper.selectByPrimaryKey(rwAsk.getId());
					if (rwAsk.getStatus() == RewardStatusEnum.OPEN.getCode()) {
						Date dateTime = new Date();
						rwAsk.setUpdateTime(dateTime);
						rwAsk.setStatusChangeTime(dateTime);
						rwAsk.setStatus(RewardStatusEnum.ANSWER.getCode());
						int status = rwAskMapper.updateByPrimaryKey(rwAsk, RewardStatusEnum.OPEN.getCode());
						if (status > 0) {
							RwAnswer rwAnswer = new RwAnswer();
							rwAnswer.setRwAskId(rwAsk.getId());
							rwAnswer.setRwAskIndex(rwAsk.getRwAskIndex());
							rwAnswer.setContent(rwAnswerContent);
							rwAnswer.setCreateBy(user.getId().intValue());
							rwAnswer.setCreateTime(dateTime);
							rwAnswer.setUpdateTime(dateTime);
							rwAnswerMapper.insert(rwAnswer);
							result.setDesc("抢红包成功");
							result.setStatus(ResultEnum.SUCCESS.getCode());
						} else {
							result.setDesc("红包已被抢");
							result.setStatus(ResultEnum.SERVER_ERROR.getCode());
						}
					} else {
						result.setDesc("红包已被抢");
						result.setStatus(ResultEnum.SERVER_ERROR.getCode());
					}
				} else {
					result.setDesc("用户非法或不存在");
					result.setStatus(ResultEnum.SERVER_ERROR.getCode());
				}

			} else {
				result.setDesc("红包任务非法参数请求");
				result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("红包任务回答异常=========>");
		}
		return result;
	}

	/**
	 * 红包提问
	 * 
	 * @param rwAsk
	 * @param rwAskQuestion
	 * @return Result<String>
	 * @author 天道
	 */
	public Result<String> submitQuestion(RwAsk rwAsk, RwAskQuestion rwAskQuestion) {
		Result<String> result = new Result<String>();
		try {
			if (null != rwAsk.getId() && rwAsk.getId() > 0) {
				rwAsk = rwAskMapper.selectByPrimaryKey(rwAsk.getId());
				if (null != rwAsk) {
					if (null != rwAskQuestion.getCreateBy() && rwAskQuestion.getCreateBy() > 0) {
						ImkUserDTO user = userMapper.selectByPrimaryKey((rwAskQuestion.getCreateBy()));
						if (null != user) {
							rwAskQuestion.setCreateTime(new Date());
							rwAskQuestion.setRwAskId(rwAsk.getId());
							rwAskQuestion.setId(null);
							int status = rwAskQuestionMapper.insert(rwAskQuestion);
							if (status > 0) {
								result.setDesc("提问成功");
								result.setStatus(ResultEnum.SUCCESS.getCode());
							} else {
								result.setDesc("提问失败请刷新重试");
								result.setStatus(ResultEnum.SERVER_ERROR.getCode());
							}
						} else {
							result.setDesc("提问者非法或不存在");
							result.setStatus(ResultEnum.SERVER_ERROR.getCode());
						}
					} else {
						result.setDesc("提问者非法参数请求");
						result.setStatus(ResultEnum.SERVER_ERROR.getCode());
					}
				} else {
					result.setDesc("红包任务不存在");
					result.setStatus(ResultEnum.SERVER_ERROR.getCode());
				}
			} else {
				result.setDesc("红包任务非法参数请求");
				result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("红包提问异常=========>");
		}
		return result;
	}
		
	/**
	 * 提交评论
	 * 
	 * @param rwAsk
	 *            红包任务
	 * @param rwComment
	 *            红包评论
	 * @param commentType
	 *            评论类型(ANSWER(回答),QUESTION(提问),GENERAL(普通))
	 * @return Result<String>
	 * @author 天道
	 */
	public Result<String> submitComment(RwAsk rwAsk, RwComment rwComment, String commentType) {
		Result<String> result = new Result<String>();
		try {
			if (null != rwAsk.getId() && rwAsk.getId() > 0) {
				rwAsk = rwAskMapper.selectByPrimaryKey(rwAsk.getId());
				if (null != rwAsk) {
					if (null != rwComment.getCreateBy() && rwComment.getCreateBy() > 0) {
						ImkUserDTO user = userMapper.selectByPrimaryKey((rwComment.getCreateBy()));
						if (null != user) {
							rwComment.setId(null);
							rwComment.setCreateTime(new Date());
							rwComment.setRwAskId(rwAsk.getId());
							rwComment.setRwAskIndex(rwAsk.getRwAskIndex());
							byte type = CommentTypeEnum.match(commentType, null).getCode();
							rwComment.setType(type);
							// 回答评论
							if (rwComment.getType() == CommentTypeEnum.ANSWER.getCode()) {
								if (null == rwComment.getRwAnswerId()) {
									result.setDesc("回答ID不能为空");
									result.setStatus(ResultEnum.SERVER_ERROR.getCode());
									return result;
								}
							}
							RwAnswer rwAnswer = rwAnswerMapper.selectByPrimaryKey(rwComment.getRwAnswerId());
							if (null == rwAnswer) {
								result.setDesc("任务回答不存在");
								result.setStatus(ResultEnum.SERVER_ERROR.getCode());
								return result;
							}
							int status = rwCommentMapper.insert(rwComment);
							if (status > 0) {
								result.setDesc("评论成功");
								result.setStatus(ResultEnum.SUCCESS.getCode());
							} else {
								result.setDesc("评论失败请刷新重试");
								result.setStatus(ResultEnum.SERVER_ERROR.getCode());
							}
						} else {
							result.setDesc("评论者非法或不存在");
							result.setStatus(ResultEnum.SERVER_ERROR.getCode());
						}
					} else {
						result.setDesc("评论者非法参数请求");
						result.setStatus(ResultEnum.SERVER_ERROR.getCode());
					}
				} else {
					result.setDesc("红包任务不存在");
					result.setStatus(ResultEnum.SERVER_ERROR.getCode());
				}
			} else {
				result.setDesc("红包任务非法参数请求");
				result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("红包评论异常=========>");
		}
		return result;

	}

}
