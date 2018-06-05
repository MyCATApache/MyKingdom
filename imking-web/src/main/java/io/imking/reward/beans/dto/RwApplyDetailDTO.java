package io.imking.reward.beans.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RwApplyDetailDTO {

    private Byte rwAskIndex;

    private String content;

    private Integer createBy;

    private Date createTime;
    
    private String title;

    private String askContent;
    
    private BigDecimal taskAmount;
}