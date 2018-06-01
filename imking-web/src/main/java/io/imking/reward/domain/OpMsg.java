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
public class OpMsg {
    private Integer id;

    private Byte type;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

    private Boolean isRead;

    private Date createTime;
}