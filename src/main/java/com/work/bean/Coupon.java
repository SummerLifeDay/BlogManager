package com.work.bean;

import lombok.Getter;
import lombok.Setter;

public class Coupon {

    /**
     * 折扣
     * 优惠券编号
     * 有效期
     * 发放一次优惠券数量
     * */

    @Getter
    @Setter
    private double discount;

    @Getter
    @Setter
    private String couponNum;

    @Getter
    @Setter
    private String term;

    @Getter
    @Setter
    private int count;
}
