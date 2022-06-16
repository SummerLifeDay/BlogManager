package com.work.model;

import lombok.Getter;
import lombok.Setter;

public class Order {
    /**
     * 订单号
     * 下单客户
     * 订单金额
     * 是否使用优惠券
     * 是否使用餐桌
     * **/
    @Getter
    @Setter
    private String orderNum;

    @Getter
    @Setter
    private String customer;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private boolean useCoupon;

    @Getter
    @Setter
    private boolean useTable;

}
