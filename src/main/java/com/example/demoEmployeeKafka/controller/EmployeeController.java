package com.example.demoEmployeeKafka.controller;

import com.example.demoEmployeeKafka.employeeservice.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

}
