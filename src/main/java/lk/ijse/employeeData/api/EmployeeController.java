package lk.ijse.employeeData.api;

import lk.ijse.employeeData.dto.EmployeeDTO;
import lk.ijse.employeeData.dto.EmployeeResponse;
import lk.ijse.employeeData.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/26/2023
 * Time : 12:17 PM
 */

//@RestController
//@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        List<EmployeeResponse> collect = employeeService.getAllEmployee().stream().map(e ->
                new EmployeeResponse(
                        e.getEmpId(),
                        e.getEmpName(),
                        e.getEmpEmail(),
                        e.getEmpDep(),
                        Base64.getDecoder().decode(e.getEmpProfile())
                )
        ).collect(Collectors.toList());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
//        return new ResponseEntity<>(collect, httpHeaders, HttpStatus.OK);
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @PostMapping//(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDTO saveEmployee(
            @RequestParam String empId,
            @RequestParam String empName,
            @RequestParam String empEmail,
            @RequestParam String empDep,
            @RequestParam MultipartFile empProfile
    ) {
        if (empProfile.isEmpty()) {
            throw new RuntimeException("employee profile is empty..!");
        }
        try {
            String empProfileStr = Base64.getEncoder().encodeToString(empProfile.getBytes());
            EmployeeDTO employeeDTO = new EmployeeDTO(empId, empName, empEmail, empDep, empProfileStr);
            return employeeService.saveEmployee(employeeDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
//            System.out.println(empProfile);
//            System.out.println("awa");
//
//            byte[] imageBytes = empProfile.getBytes();
//
//            // Set the response headers
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate content type
//
//            // You can also set other response headers if needed, like content-length, cache-control, etc.
//
//            // Return the image byte array as a ResponseEntity
//            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);


//    @PostMapping
//    public ResponseEntity<String> createResource(@RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println("awa");
//        System.out.println(file.getBytes());
//        if (!file.isEmpty()){
//            byte[] bytes = file.getBytes();
//
//            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//
//            String filePath = "D:\\working dir\\ADD\\Employee Data Mini Project (spring)\\employee-data-mini-project-Backend\\src\\main\\resources" + filename;
//
//            File imageFile = new File(filePath);
//            file.transferTo(imageFile);
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body("Resource created successfully");
//    }