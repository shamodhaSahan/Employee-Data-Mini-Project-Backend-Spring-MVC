package lk.ijse.employeeData.config;

import lk.ijse.employeeData.WebAppInitializer;
import lk.ijse.employeeData.service.utill.EmployeeServiceImpl;
import lk.ijse.employeeData.util.EntityDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 11:32 PM
 */

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackageClasses = {EmployeeServiceImpl.class, EntityDTOConverter.class})
public class WebRootConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

