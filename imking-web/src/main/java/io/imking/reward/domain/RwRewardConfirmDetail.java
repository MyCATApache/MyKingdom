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
public class RwRewardConfirmDetail {
    private Integer id;

    private Integer rwAskId;

    private Integer rwAskIndex;

    private Integer fromUserId;

    private Integer toUserId;

    private Integer amount;

    private String reason;

    private Date createTime;
}