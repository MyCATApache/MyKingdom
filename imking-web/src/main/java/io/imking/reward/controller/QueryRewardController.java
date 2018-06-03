package io.imking.reward.controller;

import io.imking.reward.beans.dto.RwApplyDetailDTO;
import io.imking.reward.services.QueryRewardService;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/queryReward")
public class QueryRewardController {

	@Autowired
	private QueryRewardService queryRewardService;

	/**
	 * 查询我参与的红包列表
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@PostMapping("/getMyParticipates")
	public Result<PageInfo<RwApplyDetailDTO>> getMyParticipates(
			@RequestParam Integer userId, @RequestParam Integer pageNum,
			@RequestParam Integer pageSize) {
		PageInfo<RwApplyDetailDTO> rs = queryRewardService.getMyParticipates(userId, pageNum, pageSize);
		return new Result<PageInfo<RwApplyDetailDTO>>(ResultEnum.SUCCESS, rs);
	}

}
