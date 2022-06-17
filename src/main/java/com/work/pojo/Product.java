package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * 商品名
     * 库存
     * 图片
     * 价格
     * **/
    @Id
    private Integer pId;
    private String pName;
    private Integer reserve;
    private String imgUrl;
    private double price;
}
