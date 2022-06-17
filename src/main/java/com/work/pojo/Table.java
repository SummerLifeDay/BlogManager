package com.work.pojo;

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
    private Integer dinerNum;
    private Integer isFree;
    private Integer totalNum;
    private Integer isBox;
}
