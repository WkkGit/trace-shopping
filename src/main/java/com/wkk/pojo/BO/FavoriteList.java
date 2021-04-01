package com.wkk.pojo.BO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 21:31
 */
@Data
@NoArgsConstructor
public class FavoriteList {
    private Integer id;
    private Integer userAccount;
    private String produceUrl;
    private String produceName;
    private Double producePrice;
    private Integer stock;
}
