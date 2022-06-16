package com.work.manager;

import com.work.mapper.CusMapper;
import com.work.model.Customer;
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
        Customer customer = new Customer(0, "lihua", "233", 50, "233");
        System.out.println(service.selectAll().toString());
    }


}
