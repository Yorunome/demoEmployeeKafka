package com.example.demoEmployeeKafka.Threads;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.collection.EmployeeCollection;

import com.example.demoEmployeeKafka.filehandlers.XMLFileHandler;

public class XMLReader extends Thread {

    public void run() {



        XMLFileHandler xmlFileHandler = new XMLFileHandler();
        Employee[] xmlEmployee = xmlFileHandler.objectCreation();
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.setEmployees(xmlEmployee);
    }
}


