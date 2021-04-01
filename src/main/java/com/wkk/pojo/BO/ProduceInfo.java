package com.wkk.pojo.BO;

import com.wkk.constants.ProduceTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wkk
 * @date 2021/3/27 20:43
 */
@Data
@NoArgsConstructor
public class ProduceInfo {
    private Integer id;
    private String produceName;
    private String produceUrl;
    private String introduction;
    private Double producePrice;
    /**
     * {@link ProduceTypeEnum}
     * 农产品类型：
     *      1:蔬菜
     *      2:水果
     *      3:坚果
     *      4:谷物
     */
    private ProduceTypeEnum produceType;
    private Integer stock;
    private String productDate;
    private String createdAt;
    private String updatedAt;
}
