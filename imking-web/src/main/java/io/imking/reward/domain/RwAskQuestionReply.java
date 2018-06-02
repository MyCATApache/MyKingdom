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
public class RwAskQuestionReply {
    private Integer id;

    private Integer rwAskQuestionId;

    private String replyContent;

    private Integer createBy;

    private Date createTime;
}