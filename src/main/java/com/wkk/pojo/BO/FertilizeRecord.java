package com.wkk.pojo.BO;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wkk
 * @String 2021/3/27 22:03
 */
@Data
@NoArgsConstructor
public class FertilizeRecord {
    private Integer id;
    private String produceName;
    private String fertilizer;
    private Integer total;
    private String timeInterval;
    private String firstTime;
    private String lastTime;
    private String createdAt;
    private String updatedAt;
}
