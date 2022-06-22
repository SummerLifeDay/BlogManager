package com.work.service;

import com.work.pojo.Customer;

import java.util.List;

public interface CusService {

    List<Customer> selectAll();

    int add(Customer customer);

    int edit(Customer customer);

    int delete(int userId);
}
