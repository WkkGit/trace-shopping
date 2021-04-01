package com.wkk.pojo.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 21:31
 */
@Data
@NoArgsConstructor
public class FavoriteListDO {
    private Integer id;
    private Integer userAccount;
    private String produceUrl;
    private String produceName;
    private Double producePrice;
    private Integer stock;
}
