package com.wkk.pojo.BO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/31 11:19
 */
@Data
@NoArgsConstructor
public class Order {
    private Integer id;
    private String deliveryNo;
    private String payStatus;
    private String sendStatus;
    private Double totalPrice;
    private Integer userAccount;
    private String address;
    private String createdAt;
    private String updatedAt;
}
