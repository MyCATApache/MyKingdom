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
public class RwProAct {
    private Integer id;

    private Integer rwAskId;

    private Integer rwAskIndex;

    private Byte type;

    private BigDecimal amount;

    private Byte applyDelayDays;

    private Integer createBy;

    private Date createTime;
}