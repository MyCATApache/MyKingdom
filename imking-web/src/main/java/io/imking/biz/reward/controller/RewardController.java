package io.imking.biz.reward.controller;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.services.RewardService;
import io.imking.core.services.RwAskService;
import io.imking.utils.Constant;
import io.imking.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
     * 
     * @param rwAsk
     * @return
     */
    @PostMapping("/getRwAskList")
    public Result<Object> getRwAskList(@RequestParam int pageNum,@RequestParam int pageSize) throws Exception{
    	Result<Object> ret = new Result<Object>();
    	pageSize = (pageSize>Constant.MAX_PAGE_SIZE?Constant.MAX_PAGE_SIZE:pageSize);
		return ret.ok(rwAskService.getRwAskList(pageNum, pageSize));
    }
	/**
	 * table切换红包任务列表
	 * 
	 * @return Result
	 * @author 天道
	 */
	@RequestMapping("/tableRwAsks")
	public Result<String> tableRwAsks() {
		Result result = new Result();
		try {
			result = rewardService.tableRwAsks();
		} catch (Exception e) {
//			result.setStatus(ResultEnum.SERVER_ERROR.getCode());
			result.setDesc("查询失败");
			e.printStackTrace();
		}
		return result;
	}
}


