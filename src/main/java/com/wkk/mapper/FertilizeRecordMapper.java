package com.wkk.mapper;

import com.wkk.pojo.DO.FertilizeRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface FertilizeRecordMapper {
    int insert(FertilizeRecordDO fertilizeRecord);

    int update(FertilizeRecordDO fertilizeRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    FertilizeRecordDO findByProduceName(String produceName);

    List<FertilizeRecordDO> findByParName(String parName);

    List<FertilizeRecordDO> list();
}
