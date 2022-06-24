package com.work.manager;

import com.work.pojo.Customer;
import com.work.service.impl.BaseServiceImpl;
import com.work.service.impl.CusServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ManagerApplicationTests {

    @Resource
    private BaseServiceImpl service;

    @Test
    void contextLoads() {
        System.out.println(service.countOrdersMoney());
    }


}
