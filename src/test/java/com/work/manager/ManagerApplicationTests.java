package com.work.manager;

import com.work.pojo.Customer;
import com.work.service.impl.CusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ManagerApplicationTests {

    @Resource
    private CusServiceImpl service;

    @Test
    void contextLoads() {
        Customer cus = new Customer();
        cus.setUserId(7);
        cus.setTelNum("244");

        System.out.println(service.edit(cus));
    }


}
