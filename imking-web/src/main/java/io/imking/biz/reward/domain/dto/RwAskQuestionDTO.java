package io.imking.biz.reward.domain.dto;

import java.util.Date;
import lombok.Data;

/**
 * @author liunan  by 2018/5/28
 */
@Data
public class RwAskQuestionDTO {

  private Integer id;

  private Integer rwAskId;

  private String questionContent;

  private Integer createBy;

  private Date createTime;

  private UserDTO userDTO;
}
