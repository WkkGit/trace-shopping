package com.wkk.mapper;

import com.wkk.pojo.DO.GrowRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface GrowRecordMapper {
    int insert(GrowRecordDO growRecord);

    int update(GrowRecordDO growRecord);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByProduceName(String produceName);

    GrowRecordDO findByProduceName(String produceName);

    List<GrowRecordDO> findByParName(String parName);

    List<GrowRecordDO> list();

    List<GrowRecordDO> findByGrowLand(String growLand);
}
