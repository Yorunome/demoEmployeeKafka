package com.example.demoEmployeeKafka.controller;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.Threads.CSVReader;
import com.example.demoEmployeeKafka.Threads.JSONReader;
import com.example.demoEmployeeKafka.Threads.XMLReader;
import com.example.demoEmployeeKafka.dto.EmployeeDto;
//import com.example.demoEmployeeKafka.employeeservice.EmployeeServiceInterface;
import com.example.demoEmployeeKafka.employeeservice.Producer;
import org.springframework.beans.BeanUtils;
//import com.example.demoEmployeeKafka.employeeservice.EmployeeServiceInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/kafka")
public class EmployeeController {

    private final Producer producer;

    @Autowired
    EmployeeController(Producer producer){
        this.producer = producer;



    }

    @PostMapping("/publish")
    public void readFiles(){

        try {
            CSVReader csvReader = new CSVReader();
            csvReader.start();
            XMLReader xmlReader = new XMLReader();
            xmlReader.start();
            JSONReader jsonReader = new JSONReader();
            jsonReader.start();

            csvReader.join();
            xmlReader.join();
            jsonReader.join();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        this.producer.sendMessage();

    }


}
