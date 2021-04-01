package com.wkk.repository;

import com.wkk.constants.SeedQualityEnum;
import com.wkk.mapper.GrowRecordMapper;
import com.wkk.pojo.BO.GrowRecord;
import com.wkk.pojo.DO.GrowRecordDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GrowRecordRepository {
    @Resource
    GrowRecordMapper mapper;
    public int insert(GrowRecordDO growRecord){
        return mapper.insert(growRecord);
    }

    public int update(GrowRecordDO growRecord){
        return mapper.update(growRecord);
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

    public GrowRecord findByProduceName(String produceName){
        return transformToBO(mapper.findByProduceName(produceName));
    }

    public List<GrowRecord> findByParName(String parName){
        List<GrowRecordDO> list = mapper.findByParName(parName);
        List<GrowRecord> res = new ArrayList<>();
        for(GrowRecordDO growRecordDO : list){
            res.add(transformToBO(growRecordDO));
        }
        return res;
    }

    public List<GrowRecord> list(){
        List<GrowRecordDO> list = mapper.list();
        List<GrowRecord> res = new ArrayList<>();
        for(GrowRecordDO growRecordDO : list){
            res.add(transformToBO(growRecordDO));
        }
        return res;
    }

    public List<GrowRecord> findByGrowLand(String growLand){
        List<GrowRecordDO> list = mapper.findByGrowLand(growLand);
        List<GrowRecord> res = new ArrayList<>();
        for(GrowRecordDO growRecordDO : list){
            res.add(transformToBO(growRecordDO));
        }
        return res;
    }

    private GrowRecord transformToBO(GrowRecordDO growRecordDO){
        GrowRecord growRecord = new GrowRecord();
        growRecord.setId(growRecordDO.getId());
        growRecord.setProduceName(growRecordDO.getProduceName());
        growRecord.setGrowLand(growRecordDO.getGrowLand());
        growRecord.setGrowTime(growRecordDO.getGrowTime());
        growRecord.setReapTime(growRecordDO.getReapTime());
        growRecord.setCreatedAt(growRecordDO.getCreatedAt());
        growRecord.setUpdatedAt(growRecordDO.getUpdatedAt());
        int code = growRecordDO.getSeedQuality();
        growRecord.setSeedQuality(SeedQualityEnum.getInstance(code));
        return growRecord;
    }
}
