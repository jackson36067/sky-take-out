package com.jackson.service.impl;

import com.jackson.constant.MessageConstant;
import com.jackson.constant.StatusConstant;
import com.jackson.dto.EmployeeLoginDTO;
import com.jackson.entity.Employee;
import com.jackson.exception.AccountLockedException;
import com.jackson.exception.AccountNotFoundException;
import com.jackson.exception.PasswordErrorException;
import com.jackson.mapper.EmployeeMapper;
import com.jackson.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();
        Employee employee = employeeMapper.login(username);
        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定)
        //账号不存在
        if (employee == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码错误
        // TODO 后期需要进行md5加密，然后再进行比对
        if (!employee.getPassword().equals(password)) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //账号被锁定 (用户账号状态为0)
        if (employee.getStatus() == StatusConstant.DISABLE) {
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }
        return employee;
    }
}
