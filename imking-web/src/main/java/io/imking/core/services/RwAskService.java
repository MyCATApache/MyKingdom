package io.imking.core.services;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
@Log4j
public class RwAskService {

    @Autowired
    private RwAskMapper rwAskMapper;

    public Result<String> saveContent(RwAsk rwAsk){
        RwAskExample example = new RwAskExample();
        RwAskExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(rwAsk.getId());
        try {
            long rwAskNum = rwAskMapper.countByExample(example);
            if(rwAskNum!=1){
                return new Result<>(ResultEnum.SERVER_ERROR , "红包异常" ) ;
            }
        }catch (Exception e){
            log.error("红包查询异常"+e.toString());
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
            log.error("红包内容存错异常"+e.toString());
            return new Result<>(ResultEnum.SERVER_ERROR , "存储异常" ) ;
        }
        return new Result<>(ResultEnum.SUCCESS , "保存成功" ) ;
    }
}
