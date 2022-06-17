package com.work.service.impl;

import com.work.mapper.StaffMapper;
import com.work.pojo.Staff;
import com.work.service.StaffService;
import com.work.utils.Log;
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
    public boolean add(Staff staff) {
        try {
            mapper.insert(staff);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Staff staff) {
        try {
            mapper.updateByPrimaryKey(staff);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(String staffId) {
        try {
            mapper.deleteByPrimaryKey(staffId);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
