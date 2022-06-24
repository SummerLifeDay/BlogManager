package com.work.service.impl;

import com.work.mapper.CusMapper;
import com.work.mapper.OrderMapper;
import com.work.mapper.ProMapper;
import com.work.pojo.Customer;
import com.work.pojo.Orders;
import com.work.pojo.Product;
import com.work.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BaseService")
public class BaseServiceImpl implements BaseService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CusMapper cusMapper;
    @Autowired
    private ProMapper proMapper;


    @Override
    public double countOrdersMoney() {
        return orderMapper.countOrdersMoney();
    }

    @Override
    public int countOrders() {
        return orderMapper.selectCount(new Orders());
    }

    @Override
    public int countCustomers() {
        return cusMapper.selectCount(new Customer());
    }

    @Override
    public int countProducts() {
        return proMapper.selectCount(new Product());
    }
}
