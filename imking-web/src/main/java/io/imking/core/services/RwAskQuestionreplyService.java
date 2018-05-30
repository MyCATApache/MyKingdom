package io.imking.core.services;

import static io.imking.utils.AssertUtil.isTure;
import static io.imking.utils.ResultEnum.INVALID_PARAM;
import static io.imking.utils.ResultEnum.RWASKQUESTION_NOT_EXIT;

import io.imking.biz.reward.domain.RwAskExample;
import io.imking.biz.reward.domain.RwAskQuestionExample;
import io.imking.biz.reward.domain.RwAskQuestionReply;
import io.imking.biz.reward.mapping.RwAskQuestionMapper;
import io.imking.biz.reward.mapping.RwAskQuestionReplyMapper;
import io.imking.utils.Result;
import java.util.Date;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 红包回答相关.
 *
 * @author liunan  by 2018/5/27
 */
@Service
@Log4j
public class RwAskQuestionreplyService {

  @Autowired
  private RwAskQuestionReplyMapper rwAskQuestionReplyMapper;

  @Autowired
  private RwAskQuestionMapper rwAskQuestionMapper;


  public Result<String> saveRwAskQuestionreply(RwAskQuestionReply reply) {

    Integer rwAskQuestionId = reply.getRwAskQuestionId();
    isTure(null != rwAskQuestionId && rwAskQuestionId > 0, INVALID_PARAM, "[rwAskQuestionId] 不合法.");
    String replyContent = reply.getReplyContent();

    isTure(StringUtils.isNotBlank(replyContent), INVALID_PARAM, "评论内容不能为空.");
    isTure(1000 > replyContent.length(), INVALID_PARAM, "评论内容过长.");
    //检查 rwAskQuestionId 是否存在
    RwAskQuestionExample rqE = new RwAskQuestionExample();
    rqE.createCriteria().andIdEqualTo(rwAskQuestionId);
    long rwAskQuestionCount = rwAskQuestionMapper.countByExample(rqE);
    isTure(0 != rwAskQuestionCount, RWASKQUESTION_NOT_EXIT,"提问不存在.");

    reply.setCreateTime(new Date());
//    reply.setCreateBy(); todo sessionUtil在哪里？
    rwAskQuestionReplyMapper.insert(reply);

    return new Result<String>().ok("") ;
  }

}
