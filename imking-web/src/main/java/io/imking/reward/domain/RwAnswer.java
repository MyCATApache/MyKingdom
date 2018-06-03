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
public class RwAnswer {
    private Integer id;

    private Integer rwAskId;

    private Byte rwAskIndex;

    private String content;

    private String attachGroup;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}