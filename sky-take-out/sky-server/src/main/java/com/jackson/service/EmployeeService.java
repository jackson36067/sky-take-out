package com.jackson.service;

import com.jackson.dto.EmployeeLoginDTO;
import com.jackson.entity.Employee;

public interface EmployeeService {
    /**
     *
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
