package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.GrowRecord;
import com.wkk.pojo.DO.GrowRecordDO;
import com.wkk.repository.GrowRecordRepository;
import com.wkk.service.GrowRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:17
 */
@Service
public class GrowRecordServiceImpl implements GrowRecordService {
    @Resource
    GrowRecordRepository growRecordRepository;

    @Override
    public int insert(GrowRecordDO growRecord) {
        return growRecordRepository.insert(growRecord);
    }

    @Override
    public int update(GrowRecordDO growRecord) {
        return growRecordRepository.update(growRecord);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return growRecordRepository.deleteBatch(ids);
    }

    @Override
    public int deleteById(Integer id) {
        return growRecordRepository.deleteById(id);
    }

    @Override
    public int deleteByProduceName(String produceName) {
        return growRecordRepository.deleteByProduceName(produceName);
    }

    @Override
    public GrowRecord findByProduceName(String produceName) {
        return growRecordRepository.findByProduceName(produceName);
    }

    @Override
    public List<GrowRecord> findByParName(String parName) {
        return growRecordRepository.findByParName(parName);
    }

    @Override
    public List<GrowRecord> list() {
        return growRecordRepository.list();
    }

    @Override
    public List<GrowRecord> findByGrowLand(String growLand) {
        return growRecordRepository.findByGrowLand(growLand);
    }

    @Override
    public PageInfo<GrowRecord> pageGrowRecord(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<GrowRecord> list = growRecordRepository.list();
        PageInfo<GrowRecord> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
