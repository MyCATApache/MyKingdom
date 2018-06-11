package io.imking.reward.controller;


import io.imking.reward.beans.dto.RwDetailDto;
import io.imking.reward.beans.enums.RewardStatusEnum;
import io.imking.reward.domain.RwAsk;
import io.imking.reward.domain.RwAskQuestion;
import io.imking.reward.domain.RwComment;
import io.imking.reward.domain.RwRewardConfirmDetail;
import io.imking.reward.services.RewardService;
import io.imking.reward.services.RwAskService;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("/api/reward")
public class RewardController {
	
    @Autowired
    private RwAskService rwAskService;
    @Autowired
	protected RewardService rewardService;


    /**
     * 保存红包内容
     * 红包id不为空
     * 红包内容不为空
     * @param rwAsk
     * @return
     */
    @PostMapping("saveconnect")
    public Result<String> getRwId(RwAsk rwAsk){
        return rwAskService.saveContent(rwAsk);
    }

    /**
     * 更新红包内容
     * @param rwAsk
     * @return
     */
    @PostMapping("updateRwAsk")
    public Result<String> updateRwAsk(RwAsk rwAsk){
        return rwAskService.updateRwAsk(rwAsk);
    }
    
	/**
	 * table切换红包任务列表
	 * 
	 * @return Result
	 * @author 天道
	 */
	@RequestMapping("/getRwAskDetail")
	public Result<Map<String, Object>> getRwAskDetail() {
		Result<Map<String, Object>> result = new Result<>();
		try {
			result = rewardService.getRwAskDetail();
		} catch (Exception e) {
			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("查询失败");
			e.printStackTrace();
		}
		return result;
	}


    @PostMapping("/add")
    @ResponseBody
    public Result<?> newRw(@RequestParam(required=true) String title
    		) {
    	//TODO: 用户注册方式待定 暂时为1
    	int create_by = 1;
    	RwAsk rwAsk = new RwAsk();
    	rwAsk.setTitle(title);
    	rwAsk.setStatus(RewardStatusEnum.OPEN.getCode());
    	rwAsk.setCreateBy(create_by);
    	rwAsk.setCreateTime(new Date());
    	return rewardService.createRw(rwAsk);
    }
    
    @GetMapping("/list")
    @ResponseBody
    public Result<PageInfo<RwDetailDto>> searchRWByTitle(
    		@RequestParam(required=true)String title,
    		@RequestParam(defaultValue="5")int rwPageSize,
    		@RequestParam(defaultValue="1")int rwPageNum,
    		@RequestParam(defaultValue="1")int answerPageSize,
    		@RequestParam(defaultValue="1")int answerPageNum){
    	PageInfo<RwDetailDto> rs = rewardService.searchRWByTitle(title, rwPageNum, rwPageSize);
    	return new Result<PageInfo<RwDetailDto>>(ResultEnum.SUCCESS, rs);
    }

    /**
	 * 回答问题(抢红包)
	 * @return Result<String>
	 * @param rwAsk 红包任务
	 * @param rwAnswerContent 红包任务回答内容
	 * @author 天道
	 */
	@RequestMapping("/submitAnswer")
	public Result<String> submitAnswer(RwAsk rwAsk, String rwAnswerContent) {
		Result<String> result = new Result<String>();
		try {
			result = rewardService.submitAnswer(rwAsk, rwAnswerContent);
		} catch (Exception e) {
			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("抢红包失败请刷新重试");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交红包提问
	 * @return Result<String>
	 * @param rwAsk 红包任务
	 * @param rwAskQuestion 红包提问
	 * @author 天道
	 */
	@RequestMapping("/submitQuestion")
	public Result<String> submitQuestion(RwAsk rwAsk, RwAskQuestion rwAskQuestion) {
		Result<String> result = new Result<String>();
		try {
			result = rewardService.submitQuestion(rwAsk, rwAskQuestion);
		} catch (Exception e) {
			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("提交红包提问失败");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 提交红包评论
	 * @return Result<String>
	 * @param rwAsk 红包任务
	 * @param rwComment 红包评论
	 * @param commentType  评论类型(ANSWER(回答),QUESTION(提问),GENERAL(普通))
	 * @author 天道
	 */
	@RequestMapping("/submitComment")
	public Result<String> submitComment(RwAsk rwAsk, RwComment rwComment,String commentType) {
		Result<String> result = new Result<String>();
		try {
			result = rewardService.submitComment(rwAsk, rwComment,commentType);
		} catch (Exception e) {
			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("提交红包评论失败");
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 金主打赏答题者（包括全部打赏和部分打赏）
	 * @param rwAskId 任务id
	 * @param rwAskIndex 任务序号
	 * @return
	 * @author zhanyingda
	 */
	@RequestMapping("/rewardToAnswerer")
	public Result<String> rewardToAnswerer(Integer rwAskId, Integer rwAskIndex) {
		/**
		 * 1.根据rwAskId和rwAskIndex获取表rw_reward_confirm_detail最后一条记录
		 * 得到接收的用户id和金额
		 */

		/**
		 * 2.对比rw_ask表的金额，判断是否全部打赏
		 */

		/**
		 * 3.插入rw_reward_detial表一条新记录，打赏成功
		 */

		/**
		 * 4.更新rw_ask表status，status_change_time字段，修改状态为9,打赏成功
		 */

		/**
		 * 5.插入rw_ask_progress表一条新记录，记录状态变更时间
		 */

		return null;
	}


	/**
	 * 金主提议部分打赏给答题者
	 * @param rwRewardConfirmDetail
	 * @return
	 * @author zhanyingda
	 */
	@RequestMapping("/confirmPartRewardToAnswerer")
	public Result<String> confirmPartRewardToAnswerer(RwRewardConfirmDetail rwRewardConfirmDetail) {
		/**
		 * 1.插入rw_reward_confirm_detail表一条记录,fromUserId是金主，toUserId是答题者
		 */

		return null;
	}


	/**
	 * 关闭红包任务
	 * @param rwAskId 红包任务id
	 * @return
	 * @author zhanyingda
	 */
	@RequestMapping("/closeRwAsk")
	public Result<String> closeRwAsk(Integer rwAskId) {
		/**
		 * 1.更新rw_ask表status，status_change_time字段，修改状态为10,关闭红包任务
		 */

		/**
		 * 2.插入rw_ask_progress表一条新记录，记录状态变更时间
		 */
		return null;
	}


	/**
	 * 继续发布红包任务
	 * @param rwAskId
	 * @return
	 * @author zhanyingda
	 */
	@RequestMapping("/publishRwAskAgain")
	public Result<String> publishRwAskContinue(Integer rwAskId) {
		/**
		 * 1.获取rw_ask表的任务金额和rwAskIndex
		 */

		/**
		 * 2.获取rw_reward_detial表的打赏金额
		 */

		/**
		 * 3.任务金额-已打算的金额，计算剩余的金额
		 */

		/**
		 * 4.更新rw_ask表纪录，rwAskIndex+1，任务金额=剩余的金额，状态改为1
		 */

		/**
		 * 5.插入rw_ask_progress表一条新记录，记录状态变更时间
		 */

		return null;
	}


}


