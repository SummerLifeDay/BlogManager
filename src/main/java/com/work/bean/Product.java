package com.work.bean;

import lombok.Getter;
import lombok.Setter;

public class Product {
    /**
     * 商品名
     * 库存
     * 图片
     * **/
    @Getter
    @Setter
    private String pName;

    @Getter
    @Setter
    private int reserve;

    @Getter
    @Setter
    private String imgUrl;
}
