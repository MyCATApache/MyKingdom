package io.imking.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String account;

    private String pwd;

    private String realname;

    private String pinyin;

    private String nickname;

    private String gender;

    private String qq;

    private String email;

    private String website;

    private String avatar;

    private String dream;

    private Integer points;

    private Integer creditPoints;

    private Long balance;

    private Date createTime;
}
