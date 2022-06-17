package com.work.mapper;

import com.work.pojo.Table;
import com.work.utils.GeneralMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TableMapper extends GeneralMapper<Table> {
}
