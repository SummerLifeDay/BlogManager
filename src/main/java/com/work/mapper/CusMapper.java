package com.work.mapper;

import com.work.pojo.Customer;
import com.work.utils.GeneralMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CusMapper extends GeneralMapper<Customer> {
}
