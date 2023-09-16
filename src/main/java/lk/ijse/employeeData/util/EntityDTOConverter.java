package lk.ijse.employeeData.util;

import lk.ijse.employeeData.dto.EmployeeDTO;
import lk.ijse.employeeData.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/9/2023
 * Time : 1:07 PM
 */

@Component
public class EntityDTOConverter {
    private final ModelMapper modelMapper;

    public EntityDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Employee getEmployeeEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO,Employee.class);
    }
    public EmployeeDTO getEmployeeDTO(Employee employee){
        return modelMapper.map(employee,EmployeeDTO.class);
    }
}
