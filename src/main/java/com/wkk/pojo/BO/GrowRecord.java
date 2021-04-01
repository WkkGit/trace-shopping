package com.wkk.pojo.BO;

import com.wkk.constants.SeedQualityEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wkk
 * @String 2021/3/27 22:13
 */
@Data
@NoArgsConstructor
public class GrowRecord {
    private Integer id;
    private String produceName;
    /**
     * {@link SeedQualityEnum}
     * 种子质量等级
     */
    private SeedQualityEnum seedQuality;
    private String growLand;
    private String growTime;
    private String reapTime;
    private String createdAt;
    private String updatedAt;
}
