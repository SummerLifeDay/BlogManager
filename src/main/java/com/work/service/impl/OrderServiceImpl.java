package com.work.service.impl;

import com.work.mapper.OrderMapper;
import com.work.mapper.ProMapper;
import com.work.pojo.Order;
import com.work.pojo.Product;
import com.work.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public boolean add(Order order) {
        try {
            mapper.insert(order);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Order order) {
        try {
            mapper.updateByPrimaryKey(order);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(String orderId) {
        try {
            mapper.deleteByPrimaryKey(orderId);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

}
