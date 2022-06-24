package com.work.service.impl;

import com.work.mapper.TableMapper;
import com.work.pojo.Tables;
import com.work.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TableService")
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper mapper;

    @Override
    public List<Tables> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Tables selectOneByNum(int dinerNum) {
        return mapper.selectOne(new Tables(dinerNum, null, null, null));
    }

    @Override
    public int updateState(int dinerNum, int isFree) {
        return mapper.updateByPrimaryKey(new Tables(dinerNum, isFree, null, null));
    }

    @Override
    public int add(Tables tables) {
        return mapper.insertSelective(tables);
    }

    @Override
    public int edit(Tables tables) {
        return mapper.updateByPrimaryKeySelective(tables);
    }

    @Override
    public int delete(int dinerNum) {
        return mapper.deleteByPrimaryKey(dinerNum);
    }
}
