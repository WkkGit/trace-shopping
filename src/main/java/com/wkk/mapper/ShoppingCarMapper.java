package com.wkk.mapper;

import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.DO.ShoppingCarDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface ShoppingCarMapper {
    int insert(ShoppingCarDO shoppingCar);

    int update(ShoppingCarDO shoppingCar);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByAccount(Integer userAccount);

    int deleteByAccountAndName(Integer userAccount, String produceName);

    List<ShoppingCarDO> findByUserAccount(Integer userAccount);

    ShoppingCarDO findByNameAndAccount(String produceName, Integer userAccount);

    List<ShoppingCarDO> list();
}
