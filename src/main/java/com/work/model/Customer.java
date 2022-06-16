package com.work.model;

import lombok.Getter;
import lombok.Setter;

public class Customer {
    /**
     * 客户姓名
     * 电话
     * 积分
     * 生日
     * **/
    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String telNum;

    @Getter
    @Setter
    private String integral;

    @Getter
    @Setter
    private String birthday;
}
