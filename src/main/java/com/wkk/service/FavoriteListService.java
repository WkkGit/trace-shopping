package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.FavoriteList;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.FavoriteListDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
public interface FavoriteListService {

    int addItem(String produceName, Integer userAccount);

    int deleteItem(Integer userAccount, String produceName);

    int cleanShoppingCar(Integer userAccount);

    int updateShoppingCar(FavoriteListDO favoriteListDO);

    List<FavoriteList> findByUserAccount(Integer userAccount);

    PageInfo<UserInfo> pageCourse(Integer index, Integer size);
}
