package com.wkk.pojo.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @date 2021/3/27 20:43
 */
@Data
@NoArgsConstructor
public class ProduceInfoDO {
    private Integer id;
    private String produceName;
    private String produceUrl;
    private String introduction;
    private Double producePrice;
    private Integer produceType;
    private Integer stock;
    private String productDate;
    private String createdAt;
    private String updatedAt;
}
