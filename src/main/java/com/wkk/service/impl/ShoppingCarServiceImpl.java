package com.wkk.service.impl;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.ShoppingCarDO;
import com.wkk.repository.ProduceInfoRepository;
import com.wkk.repository.ShoppingCarRepository;
import com.wkk.service.ShoppingCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Resource
    ShoppingCarRepository shoppingCarRepository;
    @Resource
    ProduceInfoRepository produceInfoRepository;
    @Override
    public int addItem(String produceName, Integer userAccount) {
        ShoppingCar shoppingCar = shoppingCarRepository.findByNameAndAccount(produceName, userAccount);
        ProduceInfo produceInfo = produceInfoRepository.findByName(produceName);

        ShoppingCarDO shoppingCarDO = new ShoppingCarDO();
        shoppingCarDO.setProduceName(produceName);
        shoppingCarDO.setProducePrice(produceInfo.getProducePrice());
        shoppingCarDO.setProduceUrl(produceInfo.getProduceUrl());
        shoppingCarDO.setUserAccount(userAccount);

        if(shoppingCar != null){
            int quantity = shoppingCar.getQuantity()+1;
            Double totalprice = quantity * produceInfo.getProducePrice();
            shoppingCarDO.setId(shoppingCar.getId());
            shoppingCarDO.setQuantity(shoppingCar.getQuantity()+1);
            shoppingCarDO.setTotalPrice(totalprice);
            return shoppingCarRepository.update(shoppingCarDO);
        } else{
            shoppingCarDO.setQuantity(1);
            shoppingCarDO.setTotalPrice(produceInfo.getProducePrice());
            return shoppingCarRepository.insert(shoppingCarDO);
        }
    }

    @Override
    public int deleteItem(Integer userAccount, String produceName) {
        return shoppingCarRepository.deleteByAccountAndName(userAccount, produceName);
    }

    @Override
    public int cleanShoppingCar(Integer userAccount) {
        return 0;
    }

    @Override
    public int updateShoppingCar(ShoppingCarDO shoppingCar) {
        return 0;
    }

    @Override
    public List<ShoppingCar> findByUserAccount(Integer userAccount) {
        return shoppingCarRepository.findByUserAccount(userAccount);
    }

    @Override
    public PageInfo<UserInfo> pageCourse(Integer index, Integer size) {
        return null;
    }
}
