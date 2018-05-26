package io.imking.biz.reward.domain;

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
public class RwAsk {
    private Integer id;

    /**
     * 任务接龙序号
     */
    private Byte rwAskIndex;

    /**
     * 当前抢到红包者
     */
    private Integer currentAnswerUserId;

    /**
     * 红包类型
     */
    private Byte type;

    /**
     * 红包任务标题
     */
    private String title;

    /**
     * 红包任务内容
     */
    private String content;

    /**
     * 附件组
     */
    private String attachGroup;

    /**
     * 是否置顶
     */
    private Boolean isTop;

    /**
     * 置顶收费金额
     */
    private BigDecimal topAmount;

    /**
     * 置顶截止时间
     */
    private Date topExpirationDate;

    /**
     * 任务金额
     */
    private BigDecimal taskAmount;

    /**
     * 当前众筹金额
     */
    private BigDecimal crowdfundingAmount;

    /**
     * 红包状态
     */
    private Byte status;

    /**
     * 状态变更时间
     */
    private Date statusChangeTime;

    /**
     * 发红包者
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}