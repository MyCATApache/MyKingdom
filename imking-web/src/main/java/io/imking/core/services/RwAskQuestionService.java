package io.imking.core.services;

import static io.imking.utils.AssertUtil.isTure;
import static io.imking.utils.ResultEnum.INVALID_PARAM;
import static io.imking.utils.ResultEnum.RWASK_NOT_EXIT;

import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.domain.RwAskQuestion;
import io.imking.biz.reward.domain.RwAskQuestionExample;
import io.imking.biz.reward.domain.dto.RwAskQuestionDTO;
import io.imking.biz.reward.mapping.RwAskMapper;
import io.imking.biz.reward.mapping.RwAskQuestionMapper;
import io.imking.core.mapping.UserMapper;
import io.imking.utils.Result;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 红包提问相关.
 *
 * @author liunan  by 2018/5/27
 */
@Service
@Log4j
public class RwAskQuestionService {

  @Autowired
  private RwAskQuestionMapper rwAskQuestionMapper;

  @Autowired
  private RwAskMapper rwAskMapper;

  @Resource
  private UserMapper userMapper;

  /**
   * 保存提问.
   */
  public Result<String> saveRwAskQuestion(RwAskQuestion reply) {

    Integer rwAskId = reply.getRwAskId();
    checkRwAskId(rwAskId);

    reply.setCreateTime(new Date());
//    reply.setCreateBy(); todo sessionUtil在哪里？
    rwAskQuestionMapper.insert(reply);

    return new Result<String>().ok("");
  }

  /**
   * 查询提问列表.
   */
  public Result<List<RwAskQuestionDTO>> getRwAskQuestionDTOs(Integer rwAskId) {
    isTure(null != rwAskId, INVALID_PARAM, "[rwAskId] 不能为空.");
    checkRwAskId(rwAskId);
    RwAskQuestionExample example = new RwAskQuestionExample();
    example.createCriteria().andRwAskIdEqualTo(rwAskId);
    List<RwAskQuestion> list = rwAskQuestionMapper.selectByExample(example);
    //todo

  }

  /**
   * 检查rwAskId
   */
  private void checkRwAskId(Integer rwAskId) {
    isTure(rwAskId > 0, INVALID_PARAM, "[rwAskId] 不合法.");
    RwAskExample rqE = new RwAskExample();
    rqE.createCriteria().andIdEqualTo(rwAskId);
    long rwAsk = rwAskMapper.countByExample(rqE);
    isTure(0 != rwAsk, RWASK_NOT_EXIT, "rwAsk不存在.");
  }

}
