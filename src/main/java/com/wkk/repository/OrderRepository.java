package com.wkk.repository;

import com.wkk.mapper.OrderMapper;
import com.wkk.pojo.BO.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrderRepository {
    @Resource
    OrderMapper mapper;

    public int insert(Order order){
        return mapper.insert(order);
    }

    public int update(Order order){
        return mapper.update(order);
    }

    public int deleteByAccount(Integer userAccount){
        return mapper.deleteByAccount(userAccount);
    }

    public int deleteById(Integer id){
        return mapper.deleteById(id);
    }

    public int deleteByDeliveryNo(String deliveryNo){
        return mapper.deleteByDeliveryNo(deliveryNo);
    }

    public Order findById(Integer id){
        return mapper.findById(id);
    }

    public Order findByDeliveryNo(String deliveryNo){
        return mapper.findByDeliveryNo(deliveryNo);
    }

    public List<Order> findByUserAccount(Integer userAccount){
        return mapper.findByUserAccount(userAccount);
    }

    public List<Order> list(){
        return mapper.list();
    }
}
