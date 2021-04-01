package com.wkk.pojo.DO;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wkk
 * @date 2021/3/27 22:13
 */
@Data
@NoArgsConstructor
public class GrowRecordDO {
    private Integer id;
    private String produceName;
    private Integer seedQuality;
    private String growLand;
    private String growTime;
    private String reapTime;
    private String createdAt;
    private String updatedAt;
}
