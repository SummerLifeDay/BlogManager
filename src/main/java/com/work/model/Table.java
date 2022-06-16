package com.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@org.springframework.data.relational.core.mapping.Table(name = "table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    /**
     * 用餐人数
     * 是否空闲
     * 餐桌容纳人数
     * 是否包厢
     * */
    private int dinerNum;
    private int isFree;
    private int totalNum;
    private int isBox;
}
