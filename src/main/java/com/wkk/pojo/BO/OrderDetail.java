package com.wkk.pojo.BO;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wkk
 * @String 2021/3/27 22:06
 */
@Data
@NoArgsConstructor
public class OrderDetail {
    private Integer id;
    private String deliveryNo;
    private Integer userAccount;
    private String produceName;
    private Double producePrice;
    private Integer quantity;
    private Double totalPrice;
    private String createdAt;
    private String updatedAt;
}
