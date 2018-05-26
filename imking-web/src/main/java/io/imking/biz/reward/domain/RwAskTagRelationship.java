package io.imking.biz.reward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RwAskTagRelationship {
    private Integer id;

    private Integer rwAskId;

    private Integer tagId;
}