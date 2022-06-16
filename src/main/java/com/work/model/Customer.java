package com.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    /**
     * 客户姓名
     * 电话
     * 积分
     * 生日
     * **/
    private String userName;
    private String telNum;
    private double integral;
    private String birthday;
}
