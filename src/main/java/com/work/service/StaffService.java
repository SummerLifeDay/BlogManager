package com.work.service;

import com.work.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> selectAll();

    Staff selectOneByName(String userName);

    int findRoleByUserName(String userName);

    int add(Staff staff);

    int edit(Staff staff);

    int delete(String staffId);
}
