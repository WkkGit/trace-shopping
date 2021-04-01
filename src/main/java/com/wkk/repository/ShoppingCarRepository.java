package com.wkk.repository;

import com.wkk.mapper.ShoppingCarMapper;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.DO.ShoppingCarDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCarRepository {
    @Resource
    ShoppingCarMapper mapper;

    public int insert(ShoppingCarDO shoppingCar){
        return mapper.insert(shoppingCar);
    }

    public int update(ShoppingCarDO shoppingCar){
        return mapper.update(shoppingCar);
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

    public List<ShoppingCar> findByUserAccount(Integer userAccount){
        List<ShoppingCarDO> list = mapper.findByUserAccount(userAccount);
        List<ShoppingCar> res = new ArrayList<>();
        for(ShoppingCarDO shoppingCarDO : list){
            res.add(transformToBO(shoppingCarDO));
        }
        return res;
    }

    public ShoppingCar findByNameAndAccount(String produceName, Integer userAccount){
        if(mapper.findByNameAndAccount(produceName, userAccount) != null){
            return transformToBO(mapper.findByNameAndAccount(produceName, userAccount));
        }
        return null;
    }

    public int deleteByAccountAndName(Integer userAccount, String produceName){
        return mapper.deleteByAccountAndName(userAccount, produceName);
    }

    public List<ShoppingCar> list(){
        List<ShoppingCarDO> list = mapper.list();
        List<ShoppingCar> res = new ArrayList<>();
        for(ShoppingCarDO shoppingCarDO : list){
            res.add(transformToBO(shoppingCarDO));
        }
        return res;
    }

    private ShoppingCar transformToBO(ShoppingCarDO shoppingCarDO){
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setId(shoppingCarDO.getId());
        shoppingCar.setUserAccount(shoppingCarDO.getUserAccount());
        shoppingCar.setProduceUrl(shoppingCarDO.getProduceUrl());
        shoppingCar.setProduceName(shoppingCarDO.getProduceName());
        shoppingCar.setProducePrice(shoppingCarDO.getProducePrice());
        shoppingCar.setQuantity(shoppingCarDO.getQuantity());
        shoppingCar.setTotalPrice(shoppingCarDO.getTotalPrice());
        return shoppingCar;
    }
}
