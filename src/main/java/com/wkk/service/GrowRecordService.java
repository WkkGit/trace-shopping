package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.GrowRecord;
import com.wkk.pojo.DO.GrowRecordDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:16
 */
public interface GrowRecordService {
    int insert(GrowRecordDO growRecord);

    int update(GrowRecordDO growRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    GrowRecord findByProduceName(String produceName);

    List<GrowRecord> findByParName(String parName);

    List<GrowRecord> list();

    List<GrowRecord> findByGrowLand(String growLand);

    PageInfo<GrowRecord> pageGrowRecord(Integer index, Integer size);
}
