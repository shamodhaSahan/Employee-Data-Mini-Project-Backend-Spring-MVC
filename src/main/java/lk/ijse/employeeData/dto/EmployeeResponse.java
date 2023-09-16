package lk.ijse.employeeData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/14/2023
 * Time : 4:08 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {
    private String empId;
    private String empName;
    private String empEmail;
    private String empDep;
    private byte[] empProfile;
}
