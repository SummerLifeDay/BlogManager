package com.work.service;

import com.work.pojo.Customer;

import java.util.List;

public interface CusService {

    List<Customer> selectAll();

    boolean add(Customer customer);

    boolean edit(Customer customer);

    boolean delete(String userId);
}
