package io.imking.biz.reward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RwAskTags {
    private Integer id;

    private String type;

    private String tagName;
}