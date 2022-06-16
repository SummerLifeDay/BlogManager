package com.work.mapper;

import com.work.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CusMapper {

    @Select("select * from Customer")
    List<Customer> selectAll();
}
