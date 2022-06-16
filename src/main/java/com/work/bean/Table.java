package com.work.bean;

import lombok.Getter;
import lombok.Setter;

public class Table {

    /**
     * 用餐人数
     * 是否空闲
     * 餐桌容纳人数
     * 是否包厢
     * */

    @Getter
    @Setter
    private int dinerNum;

    @Getter
    @Setter
    private boolean isFree;

    @Getter
    @Setter
    private int totalNum;

    @Getter
    @Setter
    private boolean isBox;
}
