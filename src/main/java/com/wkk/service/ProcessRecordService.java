package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProcessRecord;
import com.wkk.pojo.DO.ProcessRecordDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:00
 */
public interface ProcessRecordService {
    int insert(ProcessRecordDO processRecord);

    int update(ProcessRecordDO processRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    ProcessRecord findByProduceName(String produceName);

    List<ProcessRecord> findByParName(String parName);

    List<ProcessRecord> list();

    List<ProcessRecord> findByProcessLand(String processLand);

    PageInfo<ProcessRecord> pageProcessRecord(Integer index, Integer size);
}
