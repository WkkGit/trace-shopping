package com.wkk.repository;

import com.wkk.mapper.FertilizeRecordMapper;
import com.wkk.pojo.BO.FertilizeRecord;
import com.wkk.pojo.DO.FertilizeRecordDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class FertilizeRecordRepository {
    @Resource
    FertilizeRecordMapper mapper;

    public int insert(FertilizeRecordDO fertilizeRecord){
        return mapper.insert(fertilizeRecord);
    }

    public int update(FertilizeRecordDO fertilizeRecord){
        return mapper.update(fertilizeRecord);
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

    public FertilizeRecord findByProduceName(String produceName){
        return transformToBO(mapper.findByProduceName(produceName));
    }

    public List<FertilizeRecord> findByParName(String parName){
        List<FertilizeRecordDO> list = mapper.findByParName(parName);
        List<FertilizeRecord> res = new ArrayList<>();
        for(FertilizeRecordDO fertilizeRecordDO : list){
            res.add(transformToBO(fertilizeRecordDO));
        }
        return res;
    }

    public List<FertilizeRecord> list(){
        List<FertilizeRecordDO> list = mapper.list();
        List<FertilizeRecord> res = new ArrayList<>();
        for(FertilizeRecordDO fertilizeRecordDO : list){
            res.add(transformToBO(fertilizeRecordDO));
        }
        return res;
    }

    private FertilizeRecord transformToBO(FertilizeRecordDO fertilizeRecordDO){
        FertilizeRecord fertilizeRecord = new FertilizeRecord();
        fertilizeRecord.setId(fertilizeRecordDO.getId());
        fertilizeRecord.setProduceName(fertilizeRecordDO.getProduceName());
        fertilizeRecord.setFertilizer(fertilizeRecordDO.getFertilizer());
        fertilizeRecord.setTotal(fertilizeRecordDO.getTotal());
        fertilizeRecord.setTimeInterval(fertilizeRecordDO.getTimeInterval());
        fertilizeRecord.setFirstTime(fertilizeRecordDO.getFirstTime());
        fertilizeRecord.setLastTime(fertilizeRecordDO.getLastTime());
        fertilizeRecord.setCreatedAt(fertilizeRecordDO.getCreatedAt());
        fertilizeRecord.setUpdatedAt(fertilizeRecordDO.getUpdatedAt());
        return fertilizeRecord;
    }
}
