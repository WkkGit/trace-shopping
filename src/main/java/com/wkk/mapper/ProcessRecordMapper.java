package com.wkk.mapper;

import com.wkk.pojo.DO.ProcessRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface ProcessRecordMapper {
    int insert(ProcessRecordDO processRecord);

    int update(ProcessRecordDO processRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    ProcessRecordDO findByProduceName(String produceName);

    List<ProcessRecordDO> findByParName(String parName);

    List<ProcessRecordDO> list();

    List<ProcessRecordDO> findByProcessLand(String processLand);
}
