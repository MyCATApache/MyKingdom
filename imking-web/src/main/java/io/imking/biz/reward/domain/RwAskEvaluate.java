package io.imking.biz.reward.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RwAskEvaluate {
    private Integer id;

    private Integer rwAskId;

    private Byte rwAskIndex;

    private Integer evaluateUserId;

    private Integer userEvaluateDimensionId;

    private Byte score;

    private Integer createBy;

    private Date createTime;
}