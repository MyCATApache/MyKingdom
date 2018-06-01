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
public class RwAskQuestion {
    private Integer id;

    private Integer rwAskId;

    private String questionContent;

    private Integer createBy;

    private Date createTime;
}