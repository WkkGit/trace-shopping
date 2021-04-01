package com.wkk.service.impl;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.OrderDetail;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.repository.OrderDetailRepository;
import com.wkk.repository.ShoppingCarRepository;
import com.wkk.repository.UserInfoRepository;
import com.wkk.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    ShoppingCarRepository shoppingCarRepository;
    @Resource
    OrderDetailRepository orderDetailRepository;
    @Resource
    UserInfoRepository userInfoRepository;

    @Override
    public void addOrderDetail(Order order, List<ShoppingCar> shoppingCarList) {
        for(ShoppingCar shoppingCar : shoppingCarList){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduceName(shoppingCar.getProduceName());
            orderDetail.setProducePrice(shoppingCar.getProducePrice());
            orderDetail.setQuantity(shoppingCar.getQuantity());
            orderDetail.setTotalPrice(shoppingCar.getTotalPrice());

            orderDetail.setUserAccount(order.getUserAccount());
            orderDetail.setDeliveryNo(order.getDeliveryNo());
            orderDetail.setCreatedAt(order.getCreatedAt());
            orderDetail.setUpdatedAt(order.getUpdatedAt());
            orderDetailRepository.insert(orderDetail);
        }
    }

    @Override
    public int updatedOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.update(orderDetail);
    }

    @Override
    public int deleteById(Integer id){
        return orderDetailRepository.deleteById(id);
    }
    @Override
    public int deleteBatch(List<String> deliveryNos) {
        return orderDetailRepository.deleteBatch(deliveryNos);
    }

    @Override
    public int deleteByDeliveryNo(String deliveryNo) {
        return orderDetailRepository.deleteByDeliveryNo(deliveryNo);
    }

    @Override
    public List<OrderDetail> findByDeliveryNo(String deliveryNo) {
        return orderDetailRepository.findByDeliveryNo(deliveryNo);
    }

    @Override
    public List<OrderDetail> findByUserAccount(Integer userAccount) {
        return orderDetailRepository.findByUserAccount(userAccount);
    }

    @Override
    public List<OrderDetail> list() {
        return orderDetailRepository.list();
    }

    @Override
    public PageInfo<Order> pageOrder(Integer index, Integer size) {
        return null;
    }
}
