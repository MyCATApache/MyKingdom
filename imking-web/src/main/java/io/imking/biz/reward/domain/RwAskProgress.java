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
public class RwAskProgress {
    private Integer id;

    private Integer rwAskId;

    private Integer rwAskIndex;

    private Byte status;

    private Date startTime;

    private Date deadlineTime;

    private Date actualEndTime;
}