package com.work.service;

import com.work.pojo.Tables;

import java.util.List;

public interface TableService {
    List<Tables> selectAll();

    Tables selectOneByNum(int dinerNum);

    int updateState(int dinerNum, int isFree);

    int add(Tables tables);

    int edit(Tables tables);

    int delete(int dinerNum);
}
