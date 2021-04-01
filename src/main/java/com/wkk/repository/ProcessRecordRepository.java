package com.wkk.repository;

import com.wkk.mapper.ProcessRecordMapper;
import com.wkk.pojo.BO.ProcessRecord;
import com.wkk.pojo.DO.ProcessRecordDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Component
public class ProcessRecordRepository {
    @Resource
    ProcessRecordMapper mapper;

    public int insert(ProcessRecordDO processRecord){
        return mapper.insert(processRecord);
    }

    public int update(ProcessRecordDO processRecord){
        return mapper.update(processRecord);
    }

    public int deleteBatch(List<Integer> ids){
        return mapper.deleteBatch(ids);
    }

    public int deleteById(Integer id){
        return mapper.deleteById(id);
    }

    public int deleteByProduceName(String produceName){
        return mapper.deleteByProduceName(produceName);
    }

    public ProcessRecord findByProduceName(String produceName){
        return transformToBO(mapper.findByProduceName(produceName));
    }

    public List<ProcessRecord> findByParName(String parName){
        List<ProcessRecordDO> list = mapper.findByParName(parName);
        List<ProcessRecord> res = new ArrayList<>();
        for (ProcessRecordDO processRecordDO : list){
            res.add(transformToBO(processRecordDO));
        }
        return res;
    }

    public List<ProcessRecord> list(){
        List<ProcessRecordDO> list = mapper.list();
        List<ProcessRecord> res = new ArrayList<>();
        for (ProcessRecordDO processRecordDO : list){
            res.add(transformToBO(processRecordDO));
        }
        return res;
    }

    public List<ProcessRecord> findByProcessLand(String processLand){
        List<ProcessRecordDO> list = mapper.findByProcessLand(processLand);
        List<ProcessRecord> res = new ArrayList<>();
        for (ProcessRecordDO processRecordDO : list){
            res.add(transformToBO(processRecordDO));
        }
        return res;
    }

    private ProcessRecord transformToBO(ProcessRecordDO processRecordDO){
        ProcessRecord processRecord = new ProcessRecord();
        processRecord.setId(processRecordDO.getId());
        processRecord.setProduceName(processRecordDO.getProduceName());
        processRecord.setProcessName(processRecordDO.getProcessName());
        processRecord.setProcessLand(processRecordDO.getProcessLand());
        processRecord.setProcessTime(processRecordDO.getProcessTime());
        processRecord.setCreatedAt(processRecordDO.getCreatedAt());
        processRecord.setUpdatedAt(processRecordDO.getUpdatedAt());
        return processRecord;
    }
}
