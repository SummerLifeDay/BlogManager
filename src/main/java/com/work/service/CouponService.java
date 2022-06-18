package com.work.service;

import com.work.pojo.Coupon;

import java.util.List;

public interface CouponService {

    List<Coupon> selectAll();

    boolean add(Coupon coupon);

    boolean edit(Coupon coupon);

    boolean delete(int couponNum);
}
