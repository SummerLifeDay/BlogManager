package com.work.mapper;

import com.work.pojo.Orders;
import com.work.utils.GeneralMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper extends GeneralMapper<Orders> {
    @Select("SELECT SUM(price) FROM orders")
    double countOrdersMoney();
}
