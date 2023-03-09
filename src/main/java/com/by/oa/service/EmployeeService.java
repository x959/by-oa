package com.by.oa.service;

import com.by.oa.entity.Employee;
import com.by.oa.mapper.EmployeeMapper;
import com.by.oa.utils.MybatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId){
        Employee emp = (Employee)MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            return employeeMapper.selectById(employeeId);
        });
        return emp;
    }
}
