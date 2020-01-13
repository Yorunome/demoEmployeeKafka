package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Threads.CSVReader;
import com.example.demoEmployeeKafka.Threads.JSONReader;
import com.example.demoEmployeeKafka.Threads.XMLReader;
import com.example.demoEmployeeKafka.employeerepository.EmployeeRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepositoryInterface employeeRepositoryInterface;

    @Override
    public void fileReaders() {

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
    }
}
