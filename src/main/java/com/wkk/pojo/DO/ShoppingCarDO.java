package com.wkk.pojo.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 21:03
 */
@Data
@NoArgsConstructor
public class ShoppingCarDO {
    private Integer id;
    private Integer userAccount;
    private String produceUrl;
    private String produceName;
    private Double producePrice;
    private Integer quantity;
    private Double totalPrice;
}
