package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@org.springframework.data.relational.core.mapping.Table(name = "tables")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tables {

    /**
     * 用餐人数
     * 是否空闲
     * 餐桌容纳人数
     * 是否包厢
     * */
    @Id
    private Integer dinerNum;
    private Integer isFree;
    private Integer totalNum;
    private Integer isBox;
}
