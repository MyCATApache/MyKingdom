package io.imking.common.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImkUserPointDetail {
    private Integer id;

    private Integer userId;

    private Integer amount;

    private Integer balance;

    private Date createTime;

    private String remark;
}