package io.imking.core.services;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
public class RwAskService {

    @Autowired
    private RwAskMapper rwAskMapper;

    public Result<String> saveContent(RwAsk rwAsk){


        RwAskExample example = new RwAskExample();
        RwAskExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(rwAsk.getId());
        try {
            int rwAskNum = rwAskMapper.selectByExample(example).size();
            if(rwAskNum!=1){
                return new Result<>(ResultEnum.SERVER_ERROR , "红包异常" ) ;
            }
        }catch (Exception e){
            return new Result<>(ResultEnum.SERVER_ERROR , "当前红包不存在" ) ;
        }
        /**
         * 判断当前操作人是否是该条红包悬赏的主人
         */


        String content = rwAsk.getContent().trim();
        if(StringUtils.isBlank(content)){
            return new Result<>(ResultEnum.SERVER_ERROR , "红包内容不允许为空" ) ;
        }
        try {
            rwAskMapper.saveContent(rwAsk);
        }catch (Exception e){
            return new Result<>(ResultEnum.SERVER_ERROR , "存储异常" ) ;
        }

        return new Result<>(ResultEnum.SUCCESS , "保存成功" ) ;
    }
}
