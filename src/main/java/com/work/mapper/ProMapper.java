package com.work.mapper;

import com.work.model.Product;
import com.work.utils.GeneralMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProMapper extends GeneralMapper<Product> {
}
