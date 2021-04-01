package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.ShoppingCarDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
public interface ShoppingCarService {
    int addItem(String produceName, Integer userAccount);

    int deleteItem(Integer userAccount, String produceName);

    int cleanShoppingCar(Integer userAccount);

    int updateShoppingCar(ShoppingCarDO shoppingCar);

    List<ShoppingCar> findByUserAccount(Integer userAccount);

    PageInfo<UserInfo> pageCourse(Integer index, Integer size);
}
