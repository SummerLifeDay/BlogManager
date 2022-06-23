package com.work.service.impl;

import com.work.mapper.OrderMapper;
import com.work.pojo.Orders;
import com.work.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Orders> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int add(Orders orders) {
        return mapper.insertSelective(orders);
    }

    @Override
    public int edit(Orders orders) {
        return mapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public int delete(String orderId) {
        return mapper.deleteByPrimaryKey(orderId);
    }

}
