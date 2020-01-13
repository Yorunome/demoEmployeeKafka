package com.example.demoEmployeeKafka.controller;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.dto.EmployeeDto;
import com.example.demoEmployeeKafka.employeeservice.EmployeeServiceInterface;
<<<<<<< HEAD
import org.springframework.beans.BeanUtils;
=======
import com.example.demoEmployeeKafka.employeeservice.EmployeeServiceInterfaceImpl;
>>>>>>> 1bcf4dbc3ab580e59da3d7d940df10033763f3f2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<String> addorupdate(@RequestBody EmployeeDto employeeDto)
    {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        Employee employeecreated=employeeServiceInterface.save(employee);
        return new ResponseEntity<String>(employeecreated.getFirstName(),HttpStatus.CREATED);
    }



=======
    public void readFiles(){
        employeeServiceInterface.fileReaders();
    }
    
}
