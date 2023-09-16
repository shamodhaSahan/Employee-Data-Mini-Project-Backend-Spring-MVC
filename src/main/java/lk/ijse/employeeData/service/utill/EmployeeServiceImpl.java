package lk.ijse.employeeData.service.utill;

import lk.ijse.employeeData.dto.EmployeeDTO;
import lk.ijse.employeeData.entity.Employee;
import lk.ijse.employeeData.repository.EmployeeRepo;
import lk.ijse.employeeData.service.EmployeeService;
import lk.ijse.employeeData.util.EntityDTOConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/2/2023
 * Time : 9:26 AM
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//        System.out.println(employeeDTO);
        Employee employeeEntity = entityDTOConverter.getEmployeeEntity(employeeDTO);
        System.out.println(employeeEntity);
        employeeRepo.save(employeeEntity);
        return employeeDTO;
    }

    @Override
    public void updateEmployee(String empId, EmployeeDTO employeeDTO) {
//        employeeRepo.save(entityDTOConverter.getEmployeeEntity(employeeDTO));
    }

    @Override
    public void deleteEmployee(String empId) {
//        employeeRepo.deleteById(empId);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(employee -> entityDTOConverter.getEmployeeDTO(employee)).collect(Collectors.toList());
//        return null;
    }
//    @Override
//    public List<EmployeeDTO> getAllEmployee() {
//        return null;
//
//        Session session = sessionFactory.openSession();
//        try {
//            return session.createQuery("FROM Employee", Employee.class).list().stream().map(this::fromEmployee).collect(Collectors.toList());
//        } finally {
//            session.close();
//        }
//        e->fromEmployee(e) - this::fromEmployee
//    }
//
//    private Employee toEmployee(EmployeeDTO employeeDTO) {
//        return new Employee(employeeDTO.getEmpId(), employeeDTO.getEmpName(), employeeDTO.getEmpEmail(), employeeDTO.getEmpDep(), employeeDTO.getEmpProfile());
//    }
//
//    private EmployeeDTO fromEmployee(Employee employee) {
//        return new EmployeeDTO(employee.getEmpId(), employee.getEmpName(), employee.getEmpEmail(), employee.getEmpDep(), employee.getEmpProfile());
//    }
}
