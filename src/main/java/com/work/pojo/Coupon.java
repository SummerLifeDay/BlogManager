package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Id;

@Table(name = "coupon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    /**
     * 折扣
     * 优惠券编号
     * 有效期
     * 发放一次优惠券数量
     * */
    @Id
    private double discount;
    private String couponNum;
    private String term;
    private Integer count;
}
