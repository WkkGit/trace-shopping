package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.OrderDetail;
import com.wkk.pojo.BO.ShoppingCar;

import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
public interface OrderDetailService {
    void addOrderDetail(Order order, List<ShoppingCar> shoppingCarList);

    int updatedOrderDetail(OrderDetail orderDetail);

    int deleteById(Integer id);

    int deleteBatch(List<String> deliveryNos);

    int deleteByDeliveryNo(String deliveryNo);

    List<OrderDetail> findByDeliveryNo(String deliveryNo);

    List<OrderDetail> findByUserAccount(Integer userAccount);

    List<OrderDetail> list();
    PageInfo<Order> pageOrder(Integer index, Integer size);
}
