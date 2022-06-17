package com.work.service;

import com.work.pojo.Table;

import java.util.List;

public interface TableService {
    List<Table> selectAll();

    Table selectOneByNum(int dinerNum);

    int updateState(int dinerNum, int isFree);

    int add(Table table);

    int edit(Table table);

    int delete(int dinerNum);
}
