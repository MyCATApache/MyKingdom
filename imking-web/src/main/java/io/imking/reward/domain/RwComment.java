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
public class RwComment {
    private Integer id;

    private Integer rwAskId;

    private Byte rwAskIndex;

    private Integer rwAnswerId;

    private Byte type;

    private String content;

    private Integer likeNum;

    private Integer createBy;

    private Date createTime;
}