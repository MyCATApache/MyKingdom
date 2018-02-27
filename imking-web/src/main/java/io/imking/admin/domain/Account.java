package io.imking.admin.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Desc: 角色账号信息类
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@Data
public class Account {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Timestamp createTime;
}
