package com.example.demoEmployeeKafka.Threads;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.collection.EmployeeCollection;
import com.example.demoEmployeeKafka.filehandlers.JSONFileHandler;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONReader extends Thread {

    public void run() {

        JSONFileHandler jsonFileHandler = new JSONFileHandler();
        Employee[] csvEmployee = jsonFileHandler.objectCreation();
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.setEmployees(csvEmployee);

    }

}
