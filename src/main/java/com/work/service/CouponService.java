package com.work.service;

import com.work.pojo.Coupon;

import java.util.List;

public interface CouponService {

    List<Coupon> selectAll();

    int add(Coupon coupon);

    int edit(Coupon coupon);

    int delete(String couponNum);
}
