package lk.ijse.employeeData.config;

import lk.ijse.employeeData.api.EmployeeController;
import lk.ijse.employeeData.entity.Employee;
import lk.ijse.employeeData.service.utill.EmployeeServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 11:32 PM
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {EmployeeController.class, EmployeeServiceImpl.class})
public class WebAppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/employeeData?createDatabaseIfNotExist=true");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "Shamodha@27");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");

        configuration.addAnnotatedClass(Employee.class);
        return configuration.buildSessionFactory();
    }
}
