package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.repository.OrderRepository;
import com.wkk.repository.ShoppingCarRepository;
import com.wkk.repository.UserInfoRepository;
import com.wkk.service.OrderDetailService;
import com.wkk.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wkk
 * @date 2021/3/30 13:19
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    ShoppingCarRepository shoppingCarRepository;
    @Resource
    OrderRepository orderRepository;
    @Resource
    UserInfoRepository userInfoRepository;
    @Resource
    OrderDetailService orderDetailService;

    @Override
    public int addOrder(Integer userAccount) {
        List<ShoppingCar> shoppingCarList = shoppingCarRepository.findByUserAccount(userAccount);
        UserInfo user = userInfoRepository.findByAccount(userAccount);
        Order order = new Order();
        order.setUserAccount(userAccount);
        order.setAddress(user.getAddress());
        Double totalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            totalPrice += shoppingCar.getTotalPrice();
        }
        order.setTotalPrice(totalPrice);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(new Date());
        order.setCreatedAt(dateStr);
        order.setUpdatedAt(dateStr);

        StringBuffer deliveryNo = new StringBuffer("D");
        deliveryNo.append(dateStr.substring(0,4));
        deliveryNo.append(dateStr.substring(5,7));
        deliveryNo.append(dateStr.substring(8,10));
        deliveryNo.append(dateStr.substring(14,16));
        deliveryNo.append(dateStr.substring(17));
        order.setDeliveryNo(deliveryNo.toString());
        order.setSendStatus("待发货");
        order.setPayStatus("已支付");

        orderDetailService.addOrderDetail(order, shoppingCarList);

        return orderRepository.insert(order);
    }

    @Override
    public int updatedOrder(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public int deleteOrder(String deliveryNo) {
        orderDetailService.deleteByDeliveryNo(deliveryNo);
        return orderRepository.deleteByDeliveryNo(deliveryNo);
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderRepository.deleteById(id);
    }

    @Override
    public List<Order> list() {
        return orderRepository.list();
    }

    @Override
    public Order findByDeliveryNo(String deliveryNo) {
        return orderRepository.findByDeliveryNo(deliveryNo);
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findByAccount(Integer userAccount) {
        return orderRepository.findByUserAccount(userAccount);
    }

    @Override
    public PageInfo<Order> pageOrder(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<Order> list = orderRepository.list();
        PageInfo<Order> pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
