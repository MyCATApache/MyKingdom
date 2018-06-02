package io.imking.common.domain;

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
public class ImkUserAccountDetail {
    private Integer id;

    private Integer userId;

    private BigDecimal amount;

    private Long balance;

    private Byte payMethod;

    private String payJustify;

    private Date createTime;

    private Date verifyTime;

    private String remark;

    private Long managerId;

    private Byte status;

    private Long taskId;
}