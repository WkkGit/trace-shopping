package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.DO.FertilizeRecordDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:09
 */
public interface FertilizeRecordService {
    int insert(FertilizeRecordDO fertilizeRecord);

    int update(FertilizeRecordDO fertilizeRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    FertilizeRecord findByProduceName(String produceName);

    List<FertilizeRecord> findByParName(String parName);

    List<FertilizeRecord> list();

    PageInfo<FertilizeRecord> pageFertilizeRecord(Integer index, Integer size);
}
