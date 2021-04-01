package com.wkk.pojo.BO;

import com.wkk.constants.AccountStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 20:12
 */
@Data
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 用户账号
     */
    private Integer account;
    private String password;
    private Integer salt;
    private String address;
    private String phone;
    /**
     * {@link AccountStatusEnum}
     * 账号状态:
     *      -1:NONE
     *      0:正常
     *      1:被冻结
     *      2:被删除
     */
    private AccountStatusEnum status;
    /**
     * 性别：1:男，0:女
     */
    private Integer gender;
}
