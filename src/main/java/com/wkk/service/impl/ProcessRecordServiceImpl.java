package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProcessRecord;
import com.wkk.pojo.DO.ProcessRecordDO;
import com.wkk.repository.ProcessRecordRepository;
import com.wkk.service.ProcessRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 14:00
 */
@Service
public class ProcessRecordServiceImpl implements ProcessRecordService {
    @Resource
    ProcessRecordRepository processRecordRepository;

    @Override
    public int insert(ProcessRecordDO processRecord) {
        return processRecordRepository.insert(processRecord);
    }

    @Override
    public int update(ProcessRecordDO processRecord) {
        return processRecordRepository.update(processRecord);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return processRecordRepository.deleteBatch(ids);
    }

    @Override
    public int deleteById(Integer id) {
        return processRecordRepository.deleteById(id);
    }

    @Override
    public int deleteByProduceName(String produceName) {
        return processRecordRepository.deleteByProduceName(produceName);
    }

    @Override
    public ProcessRecord findByProduceName(String produceName) {
        return processRecordRepository.findByProduceName(produceName);
    }

    @Override
    public List<ProcessRecord> findByParName(String parName) {
        return processRecordRepository.findByParName(parName);
    }

    @Override
    public List<ProcessRecord> list() {
        return processRecordRepository.list();
    }

    @Override
    public List<ProcessRecord> findByProcessLand(String processLand) {
        return processRecordRepository.findByProcessLand(processLand);
    }

    @Override
    public PageInfo<ProcessRecord> pageProcessRecord(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<ProcessRecord> list = processRecordRepository.list();
        PageInfo<ProcessRecord> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
