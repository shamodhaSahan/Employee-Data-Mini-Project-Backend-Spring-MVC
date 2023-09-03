package lk.ijse.employeeData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/26/2023
 * Time : 12:15 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String empId;
    private String empName;
    private String empEmail;
    private String empDep;
    private String empProfile;

    public EmployeeDTO(String empId, String empName, String empEmail, String empDep) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDep = empDep;
    }
}
