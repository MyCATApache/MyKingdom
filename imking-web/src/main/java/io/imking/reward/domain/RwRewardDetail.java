package io.imking.reward.domain;

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
public class RwRewardDetail {
    private Integer id;

    private Integer rwAskId;

    private Integer rwAskIndex;

    private Integer rewardUserId;

    private BigDecimal amount;

    private Boolean isAll;

    private String comment;

    private Date createTime;
}