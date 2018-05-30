package io.imking.biz.reward.domain.dto;

import java.util.Date;
import lombok.Data;

/**
 * @author liunan  by 2018/5/28
 */
@Data
public class UserDTO {
  private Long id;

  private String account;

  private String realname;

  private String pinyin;

  private String nickname;

  private String gender;

  private String qq;

  private String email;

  private String website;

  private String avatar;

  private String dream;

  private Integer points;

  private Integer creditPoints;

  private Long balance;

  private Date createTime;
}
