package com.work.service.impl;

import com.work.mapper.ProMapper;
import com.work.pojo.Product;
import com.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProServiceImpl implements ProductService {

    @Autowired
    private ProMapper mapper;

    @Override
    public List<Product> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public boolean add(Product product) {
        try {
            mapper.insert(product);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        try {
            mapper.updateByPrimaryKey(product);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(String pId) {
        try {
            mapper.deleteByPrimaryKey(pId);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
