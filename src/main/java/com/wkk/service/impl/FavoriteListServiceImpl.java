package com.wkk.service.impl;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.FavoriteList;
import com.wkk.pojo.BO.ProduceInfo;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.FavoriteListDO;
import com.wkk.pojo.DO.ShoppingCarDO;
import com.wkk.repository.FavoriteListRepository;
import com.wkk.repository.ProduceInfoRepository;
import com.wkk.service.FavoriteListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
@Service
public class FavoriteListServiceImpl implements FavoriteListService {
    @Resource
    FavoriteListRepository favoriteListRepository;
    @Resource
    ProduceInfoRepository produceInfoRepository;
    @Override
    public int addItem(String produceName, Integer userAccount) {
        FavoriteList favoriteList = favoriteListRepository.findByNameAndAccount(produceName, userAccount);
        ProduceInfo produceInfo = produceInfoRepository.findByName(produceName);
        FavoriteListDO favoriteListDO = new FavoriteListDO();
        favoriteListDO.setProduceName(produceName);
        favoriteListDO.setProducePrice(produceInfo.getProducePrice());
        favoriteListDO.setProduceUrl(produceInfo.getProduceUrl());
        favoriteListDO.setUserAccount(userAccount);

        if(favoriteList != null){
            int stock = favoriteList.getStock()+1;
            favoriteListDO.setId(favoriteList.getId());
            favoriteListDO.setStock(stock);
            return favoriteListRepository.update(favoriteListDO);
        } else{
            favoriteListDO.setStock(1);
            return favoriteListRepository.insert(favoriteListDO);
        }
    }

    @Override
    public int deleteItem(Integer userAccount, String produceName) {
        return favoriteListRepository.deleteByAccountAndName(userAccount, produceName);
    }

    @Override
    public int cleanShoppingCar(Integer userAccount) {
        return 0;
    }

    @Override
    public int updateShoppingCar(FavoriteListDO favoriteListDO) {
        return 0;
    }

    @Override
    public List<FavoriteList> findByUserAccount(Integer userAccount) {
        return favoriteListRepository.findByUserAccount(userAccount);
    }

    @Override
    public PageInfo<UserInfo> pageCourse(Integer index, Integer size) {
        return null;
    }
}
