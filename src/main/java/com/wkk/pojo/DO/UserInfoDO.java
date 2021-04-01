package com.wkk.pojo.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 20:12
 */
@Data
@NoArgsConstructor
public class UserInfoDO {
    private Integer id;
    private String userName;
    private Integer account;
    private String password;
    private Integer salt;
    private String address;
    private String phone;
    private Integer status;
    private Integer gender;
}
