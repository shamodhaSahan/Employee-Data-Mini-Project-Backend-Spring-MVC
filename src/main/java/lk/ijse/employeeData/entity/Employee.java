package lk.ijse.employeeData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/26/2023
 * Time : 12:15 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "employee_Id")
    private String empId;
    @Column(name = "name")
    private String empName;
    @Column(name = "email")
    private String empEmail;
    @Column(name = "dep")
    private String empDep;
    @Column(name = "profile")
    private String empProfile;
}
