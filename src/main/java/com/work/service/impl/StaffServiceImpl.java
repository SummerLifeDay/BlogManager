package com.work.service.impl;

import com.work.mapper.StaffMapper;
import com.work.pojo.Staff;
import com.work.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StaffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper mapper;

    @Override
    public List<Staff> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Staff selectOneByName(String userName) {
        Staff staff = null;
        staff = mapper.selectOne(new Staff(null, userName, null, null, null));

        if (staff != null) {
            return staff;
        }
        return null;
    }

    @Override
    public int findRoleByUserName(String userName) {
        Staff staff = selectOneByName(userName);
        if (staff != null){
            return staff.getRole();
        }

        return 1;
    }

    @Override
    public int add(Staff staff) {
        return mapper.insertSelective(staff);
    }

    @Override
    public int edit(Staff staff) {
        return mapper.updateByPrimaryKeySelective(staff);
    }

    @Override
    public int delete(String staffId) {
        return mapper.deleteByPrimaryKey(staffId);
    }
}
