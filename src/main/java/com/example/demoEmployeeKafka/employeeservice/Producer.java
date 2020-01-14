package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.collection.EmployeeCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {

    private static String TOPIC = "test";


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(){

        EmployeeCollection employeeCollection = new EmployeeCollection();
        List<Employee> employees = employeeCollection.getEmployees();

        for (int i = 0; i < employees.size(); i++) {
            this.kafkaTemplate.send(TOPIC, (employees.get(i).getFirstName()));
            this.kafkaTemplate.send(TOPIC, (employees.get(i).getLastName()));
            this.kafkaTemplate.send(TOPIC, (employees.get(i).getDateOfJoining().toString()));
            //this.kafkaTemplate.send(TOPIC, (employees.get(i).getExperience()));
        }
    }


}
