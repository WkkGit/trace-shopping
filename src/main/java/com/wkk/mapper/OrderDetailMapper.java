package com.wkk.mapper;

import com.wkk.pojo.BO.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderDetailMapper {
    int insert(OrderDetail orderDetail);

    int update(OrderDetail orderDetail);

    int deleteById(Integer id);

    int deleteBatch(List<String> deliveryNos);

    int deleteByDeliveryNo(String deliveryNo);

    List<OrderDetail> findByDeliveryNo(String deliveryNo);

    List<OrderDetail> findByUserAccount(Integer userAccount);

    List<OrderDetail> list();
}
