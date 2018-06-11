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
public class CrowdfundingInfo {
    private Integer id;

    private Integer rwAskId;

    private Integer amount;

    private Integer createBy;

    private Date createTime;
}