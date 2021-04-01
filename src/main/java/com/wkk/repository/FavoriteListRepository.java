package com.wkk.repository;

import com.wkk.mapper.FavoriteListMapper;
import com.wkk.pojo.BO.FavoriteList;
import com.wkk.pojo.DO.FavoriteListDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteListRepository {
    @Resource
    FavoriteListMapper mapper;

    public int insert(FavoriteListDO favoriteList){
        return mapper.insert(favoriteList);
    }

    public int update(FavoriteListDO favoriteList){
        return mapper.update(favoriteList);
    }

    public int deleteBatch(List<Integer> ids){
        return mapper.deleteBatch(ids);
    }

    public int deleteById(Integer id){
        return mapper.deleteById(id);
    }

    public int deleteByAccount(Integer userAccount){
        return mapper.deleteByAccount(userAccount);
    }

    public int deleteByAccountAndName(Integer userAccount, String produceName){
        return mapper.deleteByAccountAndName(userAccount, produceName);
    }

    public List<FavoriteList> findByUserAccount(Integer account){
        List<FavoriteListDO> list = mapper.findByUserAccount(account);
        List<FavoriteList> res = new ArrayList<>();
        for(FavoriteListDO favoriteListDO : list){
            res.add(transformToBO(favoriteListDO));
        }
        return res;
    }

    public FavoriteList findByNameAndAccount(String produceName, Integer account){
        if(mapper.findByNameAndAccount(produceName, account) != null){
            return transformToBO(mapper.findByNameAndAccount(produceName, account));
        }
        return null;
    }
    public List<FavoriteList> list(){
        List<FavoriteListDO> list = mapper.list();
        List<FavoriteList> res = new ArrayList<>();
        for(FavoriteListDO favoriteListDO : list){
            res.add(transformToBO(favoriteListDO));
        }
        return res;
    }

    private FavoriteList transformToBO(FavoriteListDO favoriteListDO){
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(favoriteListDO.getId());
        favoriteList.setUserAccount(favoriteListDO.getUserAccount());
        favoriteList.setProduceUrl(favoriteListDO.getProduceUrl());
        favoriteList.setProduceName(favoriteListDO.getProduceName());
        favoriteList.setProducePrice(favoriteListDO.getProducePrice());
        favoriteList.setStock(favoriteListDO.getStock());
        return favoriteList;
    }
}
