package lk.ijse.employeeData.service.utill;

import lk.ijse.employeeData.dto.EmployeeDTO;
import lk.ijse.employeeData.entity.Employee;
import lk.ijse.employeeData.service.EmployeeService;
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
    SessionFactory sessionFactory;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(toEmployee(employeeDTO));
            transaction.commit();
            return employeeDTO;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void updateEmployee(String empId, EmployeeDTO employeeDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(toEmployee(employeeDTO));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteEmployee(String empId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Employee employee = session.get(Employee.class, empId);
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Employee", Employee.class).list().stream().map(this::fromEmployee).collect(Collectors.toList());
        } finally {
            session.close();
        }
//        e->fromEmployee(e) - this::fromEmployee
    }

    private Employee toEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getEmpId(), employeeDTO.getEmpName(), employeeDTO.getEmpEmail(), employeeDTO.getEmpDep(), employeeDTO.getEmpProfile());
    }

    private EmployeeDTO fromEmployee(Employee employee) {
        return new EmployeeDTO(employee.getEmpId(), employee.getEmpName(), employee.getEmpEmail(), employee.getEmpDep(), employee.getEmpProfile());
    }
}
