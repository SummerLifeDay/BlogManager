package com.work.service.impl;

import com.work.mapper.CusMapper;
import com.work.pojo.Customer;
import com.work.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean add(Customer customer) {
        try {
            mapper.insert(customer);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Customer customer) {
        try {
            mapper.updateByPrimaryKey(customer);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int userId) {
        try {
            mapper.deleteByPrimaryKey(userId);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }


}
