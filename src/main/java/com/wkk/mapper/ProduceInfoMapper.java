package com.wkk.mapper;

import com.wkk.pojo.DO.ProduceInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface ProduceInfoMapper {
    int insert(ProduceInfoDO produceInfo);

    int update(ProduceInfoDO produceInfo);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByName(String produceName);

    ProduceInfoDO findByName(String produceName);

    List<ProduceInfoDO> findByParName(String parName);

    List<ProduceInfoDO> list();

    List<ProduceInfoDO> findByProduceType(Integer produceType);
}
