package lk.ijse.employeeData.api;

import lk.ijse.employeeData.dto.EmployeeDTO;
import lk.ijse.employeeData.entity.Employee;
import lk.ijse.employeeData.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/26/2023
 * Time : 12:17 PM
 */

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDTO saveEmployee(
            @RequestPart String empId,
            @RequestPart String empName,
            @RequestPart String empEmail,
            @RequestPart String empDep,
            @RequestPart byte[] empProfile
    ) {
        String empProfileStr = Base64.getEncoder().encodeToString(empProfile);
        return employeeService.saveEmployee(new EmployeeDTO(empId, empName, empEmail, empDep, empProfileStr));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("empId")
    public void updateEmployee(@PathVariable String empId, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(empId, employeeDTO);
    }

    @DeleteMapping(params = "id")
    public void deleteEmployee(String id) {
        employeeService.deleteEmployee(id);
    }

}
