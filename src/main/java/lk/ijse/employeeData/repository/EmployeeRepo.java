package lk.ijse.employeeData.repository;

import lk.ijse.employeeData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/9/2023
 * Time : 1:13 PM
 */

public interface EmployeeRepo extends JpaRepository<Employee,String> {
}
