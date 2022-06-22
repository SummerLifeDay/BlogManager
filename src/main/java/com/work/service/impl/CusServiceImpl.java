package com.work.service.impl;

import com.work.mapper.CusMapper;
import com.work.pojo.Customer;
import com.work.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("CusService")
public class CusServiceImpl implements CusService {

    @Autowired
    private CusMapper mapper;

    @Override
    public List<Customer> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int add(Customer customer) {
        return mapper.insertSelective(customer);
    }

    @Override
    public int edit(Customer customer) {
        return mapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int delete(int userId) {
        return mapper.deleteByPrimaryKey(userId);
    }


}
