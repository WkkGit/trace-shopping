package com.wkk.mapper;

import com.wkk.pojo.BO.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface OrderMapper {
    int insert(Order order);

    int update(Order order);

    int deleteByAccount(Integer userAccount);

    int deleteById(Integer id);

    int deleteByDeliveryNo(String deliveryNo);

    Order findById(Integer id);

    Order findByDeliveryNo(String deliveryNo);

    List<Order> findByUserAccount(Integer userAccount);

    List<Order> list();
}
