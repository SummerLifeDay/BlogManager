package com.work.service.impl;

import com.work.mapper.CusMapper;
import com.work.model.Customer;
import com.work.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CusServiceImpl implements CusService {

    @Autowired
    CusMapper cusMapper;

    @Override
    public void selectAll() {
        List<Customer> cus = cusMapper.selectAll();
    }
}
