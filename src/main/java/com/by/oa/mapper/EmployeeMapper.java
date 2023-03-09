package com.by.oa.mapper;

import com.by.oa.entity.Employee;

public interface EmployeeMapper {
    public Employee selectById(Long employeeId);
}
