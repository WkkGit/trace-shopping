package com.wkk.pojo.BO;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wkk
 * @date 2021/3/28 0:13
 */
@Data
@NoArgsConstructor
public class ProcessRecord {
    private Integer id;
    private String produceName;
    private String processName;
    private String processLand;
    private String processTime;
    private String createdAt;
    private String updatedAt;
}
