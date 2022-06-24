package com.work.service;

import org.apache.ibatis.annotations.Select;

public interface BaseService {

    double countOrdersMoney();

    int countOrders();

    int countCustomers();

    int countProducts();
}
