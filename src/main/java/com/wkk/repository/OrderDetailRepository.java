package com.wkk.repository;

import com.wkk.mapper.OrderDetailMapper;
import com.wkk.pojo.BO.OrderDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrderDetailRepository {
    @Resource
    OrderDetailMapper mapper;

    public int insert(OrderDetail orderDetail){
        return mapper.insert(orderDetail);
    }

    public int update(OrderDetail orderDetail){
        return mapper.update(orderDetail);
    }

    public int deleteById(Integer id){
        return mapper.deleteById(id);
    }

    public int deleteBatch(List<String> deliveryNos){
        return mapper.deleteBatch(deliveryNos);
    }

    public int deleteByDeliveryNo(String deliveryNo){
        return mapper.deleteByDeliveryNo(deliveryNo);
    }

    public List<OrderDetail> findByDeliveryNo(String deliveryNo){
        return mapper.findByDeliveryNo(deliveryNo);
    }

    public List<OrderDetail> findByUserAccount(Integer userAccount){
        return mapper.findByUserAccount(userAccount);
    }

    public List<OrderDetail> list(){
        return mapper.list();
    }

}
