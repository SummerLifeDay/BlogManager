package com.work.service;

import com.work.model.Customer;
import com.work.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> selectAll();

    boolean add(Product product);

    boolean edit(Product product);

    boolean delete(String pId);
}
