package com.work.service;

import com.work.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> selectAll();

    int add(Product product);

    int edit(Product product);

    int delete(int pId);

    int count();
}
