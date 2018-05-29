package io.imking.biz.reward.domain;

import java.math.BigDecimal;
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

    private BigDecimal topAmount;

    private Date topExpirationDate;

    private BigDecimal taskAmount;

    private BigDecimal crowdfundingAmount;

    private Byte status;

    private Date statusChangeTime;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}