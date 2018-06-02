package io.imking.common.beans.dto;

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
public class ImkUserDTO {
    private Integer id;

    private String account;

    private String realname;

    private String pinyin;

    private String nickname;

    private String gender;

    private String qq;

    private String email;

    private String website;

    private String avatar;

    private String dream;

    private Byte level;

    private Integer points;

    private Integer creditPoints;

    private BigDecimal balance;

    private Date createTime;
}