package com.wkk.repository;

import com.wkk.constants.ProduceTypeEnum;
import com.wkk.mapper.ProduceInfoMapper;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.DO.ProduceInfoDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProduceInfoRepository {
    @Resource
    ProduceInfoMapper mapper;

    public int insert(ProduceInfoDO produceInfo){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        produceInfo.setCreatedAt(date);
        produceInfo.setUpdatedAt(date);
        return mapper.insert(produceInfo);
    }

    public int update(ProduceInfoDO produceInfo){
        return mapper.update(produceInfo);
    }

    public int deleteBatch(List<Integer> ids){
        return mapper.deleteBatch(ids);
    }

    public int deleteById(Integer id){
        return mapper.deleteById(id);
    }

    public int deleteByName(String produceName){
        return mapper.deleteByName(produceName);
    }

    public ProduceInfo findByName(String produceName){
        return transformToBO(mapper.findByName(produceName));
    }

    public List<ProduceInfo> findByParName(String parName){
        List<ProduceInfoDO> list = mapper.findByParName(parName);
        List<ProduceInfo> res = new ArrayList<>();
        for(ProduceInfoDO produceInfoDO : list){
            res.add(transformToBO(produceInfoDO));
        }
        return res;
    }

    public List<ProduceInfo> list(){
        List<ProduceInfoDO> list = mapper.list();
        List<ProduceInfo> res = new ArrayList<>();
        for(ProduceInfoDO produceInfoDO : list){
            res.add(transformToBO(produceInfoDO));
        }
        return res;
    }

    public List<ProduceInfo> findByProduceType(Integer produceType){
        List<ProduceInfoDO> list = mapper.findByProduceType(produceType);
        List<ProduceInfo> res = new ArrayList<>();
        for(ProduceInfoDO produceInfoDO : list){
            res.add(transformToBO(produceInfoDO));
        }
        return res;
    }

    private ProduceInfo transformToBO(ProduceInfoDO produceInfoDO){
        ProduceInfo produceInfo = new ProduceInfo();
        produceInfo.setId(produceInfoDO.getId());
        produceInfo.setProduceName(produceInfoDO.getProduceName());
        produceInfo.setProduceUrl(produceInfoDO.getProduceUrl());
        produceInfo.setIntroduction(produceInfoDO.getIntroduction());
        produceInfo.setProducePrice(produceInfoDO.getProducePrice());
        produceInfo.setStock(produceInfoDO.getStock());
        produceInfo.setProductDate(produceInfoDO.getProductDate());
        produceInfo.setCreatedAt(produceInfoDO.getCreatedAt());
        produceInfo.setUpdatedAt(produceInfoDO.getUpdatedAt());
        int code = produceInfoDO.getProduceType();
        produceInfo.setProduceType(ProduceTypeEnum.getInstance(code));
        return produceInfo;
    }
}
