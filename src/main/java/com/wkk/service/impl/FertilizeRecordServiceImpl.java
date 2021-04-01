package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.DO.FertilizeRecordDO;
import com.wkk.repository.FertilizeRecordRepository;
import com.wkk.service.FertilizeRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:11
 */
@Service
public class FertilizeRecordServiceImpl implements FertilizeRecordService {
    @Resource
    FertilizeRecordRepository fertilizeRecordRepository;

    @Override
    public int insert(FertilizeRecordDO fertilizeRecord) {
        return fertilizeRecordRepository.insert(fertilizeRecord);
    }

    @Override
    public int update(FertilizeRecordDO fertilizeRecord) {
        return fertilizeRecordRepository.update(fertilizeRecord);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return fertilizeRecordRepository.deleteBatch(ids);
    }

    @Override
    public int deleteById(Integer id) {
        return fertilizeRecordRepository.deleteById(id);
    }

    @Override
    public int deleteByProduceName(String produceName) {
        return fertilizeRecordRepository.deleteByProduceName(produceName);
    }

    @Override
    public FertilizeRecord findByProduceName(String produceName) {
        return fertilizeRecordRepository.findByProduceName(produceName);
    }

    @Override
    public List<FertilizeRecord> findByParName(String parName) {
        return fertilizeRecordRepository.findByParName(parName);
    }

    @Override
    public List<FertilizeRecord> list() {
        return fertilizeRecordRepository.list();
    }

    @Override
    public PageInfo<FertilizeRecord> pageFertilizeRecord(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<FertilizeRecord> list = fertilizeRecordRepository.list();
        PageInfo<FertilizeRecord> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
