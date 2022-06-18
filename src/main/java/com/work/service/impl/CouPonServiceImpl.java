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
    public boolean add(Coupon coupon) {
        try {
            mapper.insert(coupon);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Coupon coupon) {
        try {
            mapper.updateByPrimaryKey(coupon);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int couponNum) {
        try {
            mapper.deleteByPrimaryKey(couponNum);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
