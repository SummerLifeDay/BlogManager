package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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
    @Id
    private Integer userId;
    private String userName;
    private String telNum;
    private double integral;
    private String birthday;
}
