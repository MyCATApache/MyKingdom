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
public class CrowdFundingInfo {
    private Integer id;

    private Integer rwAskId;

    private BigDecimal amount;

    private Integer createBy;

    private Date createTime;
}