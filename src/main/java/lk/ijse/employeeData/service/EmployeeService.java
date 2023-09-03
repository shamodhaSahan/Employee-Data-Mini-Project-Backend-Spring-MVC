package lk.ijse.employeeData.service;

import lk.ijse.employeeData.dto.EmployeeDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/2/2023
 * Time : 9:26 AM
 */
public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(String empId, EmployeeDTO employeeDTO);

    void deleteEmployee(String empId);

    List<EmployeeDTO> getAllEmployee();
}
