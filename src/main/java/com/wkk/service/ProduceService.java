package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.ProduceInfoDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
public interface ProduceService {
    int insert(ProduceInfoDO produceInfo);

    int update(ProduceInfoDO produceInfo);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByName(String produceName);

    ProduceInfo findByName(String produceName);

    List<ProduceInfo> findByParName(String parName);

    List<ProduceInfo> list();

    List<ProduceInfo> findByProduceType(Integer produceType);

    PageInfo<ProduceInfo> pageUser(Integer index, Integer size);
}
