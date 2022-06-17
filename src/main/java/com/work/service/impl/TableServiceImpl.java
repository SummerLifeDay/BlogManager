package com.work.service.impl;

import com.work.mapper.TableMapper;
import com.work.pojo.Table;
import com.work.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TableService")
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper mapper;

    @Override
    public List<Table> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Table selectOneByNum(int dinerNum) {
        return mapper.selectOne(new Table(dinerNum, null, null, null));
    }

    @Override
    public int updateState(Table table) {
        return mapper.updateByPrimaryKey(new Table(table.getDinerNum(), table.getIsFree(), null, null));
    }

    @Override
    public int add(Table table) {
        return mapper.insert(table);
    }

    @Override
    public int edit(Table table) {
        return mapper.updateByPrimaryKey(table);
    }

    @Override
    public int delete(int dinerNum) {
        return mapper.deleteByPrimaryKey(dinerNum);
    }
}
