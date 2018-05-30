package io.imking.biz.reward.controller;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskQuestion;
import io.imking.biz.reward.domain.RwAskQuestionReply;
import io.imking.biz.reward.domain.dto.RwAskQuestionDTO;
import io.imking.core.services.RwAskQuestionService;
import io.imking.core.services.RwAskQuestionreplyService;
import io.imking.core.services.RwAskService;
import io.imking.utils.AssertUtil;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reward")
public class RewardController {

    @Autowired
    private RwAskService rwAskService;

    @Resource
    private RwAskQuestionreplyService rwAskQuestionreplyService;
    @Resource
    private RwAskQuestionService rwAskQuestionService;

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
     * 提交问题回答
     * @param rwAskQuestionReply
     * @return
     */
    @PostMapping("rwAskQuestionReply")
    public Result<String> saveRwAskQuestionReply(@RequestBody  RwAskQuestionReply rwAskQuestionReply){

        return rwAskQuestionreplyService.saveRwAskQuestionreply(rwAskQuestionReply);
    }

    /**
     * 提交问题
     * @param rwAskQuestion
     * @return
     */
    @PostMapping("rwAskQuestion")
    public Result<String> saveRwAskQuestionReply(@RequestBody RwAskQuestion rwAskQuestion){
        return rwAskQuestionService.saveRwAskQuestion(rwAskQuestion);
    }


}


