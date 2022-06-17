package com.work.service;

import com.work.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> selectAll();

    Staff selectOneByName(String userName);

    boolean add(Staff staff);

    boolean edit(Staff staff);

    boolean delete(String staffId);
}
