package com.work.service.impl;

import com.work.mapper.CusMapper;
import com.work.model.Customer;
import com.work.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CusService")
public class CusServiceImpl implements CusService {

    @Autowired
    private CusMapper mapper;

    @Override
    public List<Customer> selectAll() {
        return mapper.selectAll();
    }
}
