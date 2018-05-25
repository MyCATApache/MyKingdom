package io.imking.biz.reward.controller;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.core.services.RwAskService;
import io.imking.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/reward")
public class RewardNextTwoController {

        @Autowired
        private RwAskService rwAskService;


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
}


