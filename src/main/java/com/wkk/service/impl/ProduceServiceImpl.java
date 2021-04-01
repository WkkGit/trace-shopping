package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.ProduceInfoDO;
import com.wkk.repository.ProduceInfoRepository;
import com.wkk.service.ProduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
@Service
public class ProduceServiceImpl implements ProduceService {
    @Resource
    ProduceInfoRepository produceInfoRepository;


    @Override
    public int insert(ProduceInfoDO produceInfo) {
        return produceInfoRepository.insert(produceInfo);
    }

    @Override
    public int update(ProduceInfoDO produceInfo) {
        return produceInfoRepository.update(produceInfo);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return produceInfoRepository.deleteBatch(ids);
    }

    @Override
    public int deleteById(Integer id) {
        return produceInfoRepository.deleteById(id);
    }

    @Override
    public int deleteByName(String produceName) {
        return produceInfoRepository.deleteByName(produceName);
    }

    @Override
    public ProduceInfo findByName(String produceName) {
        return produceInfoRepository.findByName(produceName);
    }

    @Override
    public List<ProduceInfo> findByParName(String parName) {
        return produceInfoRepository.findByParName(parName);
    }

    @Override
    public List<ProduceInfo> list() {
        return produceInfoRepository.list();
    }

    @Override
    public List<ProduceInfo> findByProduceType(Integer produceType) {
        return produceInfoRepository.findByProduceType(produceType);
    }

    @Override
    public PageInfo<ProduceInfo> pageUser(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<ProduceInfo> list = produceInfoRepository.list();
        PageInfo<ProduceInfo> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
