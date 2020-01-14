package com.example.demoEmployeeKafka.Threads;


import com.example.demoEmployeeKafka.collection.*;
import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.filehandlers.CSVFileHandler;
import com.example.demoEmployeeKafka.filehandlers.XMLFileHandler;


public class CSVReader extends Thread {

    public void run(){
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        Employee[] csvEmployee = csvFileHandler.objectCreation();
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.setEmployees(csvEmployee);

    }

}
