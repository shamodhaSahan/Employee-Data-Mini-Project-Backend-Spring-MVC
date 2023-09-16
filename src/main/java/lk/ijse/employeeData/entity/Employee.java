package lk.ijse.employeeData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
    private String empId;
    @Column(nullable = false)
    private String empName;
    @Column(nullable = false)
    private String empEmail;
    @Column(nullable = false)
    private String empDep;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String empProfile;
}
