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
    public int add(Product product) {
        return mapper.insertSelective(product);
    }

    @Override
    public int edit(Product product) {
        return mapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int delete(int pId) {
        return mapper.deleteByPrimaryKey(pId);
    }

    @Override
    public int count() {
        return selectAll().size();
    }
}
