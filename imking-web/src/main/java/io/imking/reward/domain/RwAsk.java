package io.imking.reward.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RwAsk {
    private Integer id;

    private Byte rwAskIndex;

    private Integer currentAnswerUserId;

    private Byte type;

    private String title;

    private String content;

    private String attachGroup;

    private Boolean isTop;

    private Integer topAmount;

    private Date topExpirationDate;

    private Integer taskAmount;

    private Integer crowdfundingAmount;

    private Byte status;

    private Date statusChangeTime;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}