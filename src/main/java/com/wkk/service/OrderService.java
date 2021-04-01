package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.ShoppingCarDO;

import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
public interface OrderService {
    int addOrder(Integer userAccount);

    int updatedOrder(Order order);

    int deleteOrder(String deliveryNo);

    int deleteOrder(Integer id);

    List<Order> list();

    Order findByDeliveryNo(String deliveryNo);

    Order findById(Integer id);

    List<Order> findByAccount(Integer userAccount);

    PageInfo<Order> pageOrder(Integer index, Integer size);
}
