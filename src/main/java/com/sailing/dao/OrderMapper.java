package com.sailing.dao;

import com.sailing.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByBid(String Bid);

    List<Order> selectBySid(String Sid);
}