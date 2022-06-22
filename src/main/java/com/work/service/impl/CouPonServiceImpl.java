package com.work.service.impl;

import com.work.mapper.CouponMapper;
import com.work.pojo.Coupon;
import com.work.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CouPonService")
public class CouPonServiceImpl implements CouponService {

    @Autowired
    private CouponMapper mapper;

    @Override
    public List<Coupon> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int add(Coupon coupon) {
        return mapper.insertSelective(coupon);
    }

    @Override
    public int edit(Coupon coupon) {
        return mapper.insertSelective(coupon);
    }

    @Override
    public int delete(int couponNum) {
        return mapper.deleteByPrimaryKey(couponNum);
    }
}
