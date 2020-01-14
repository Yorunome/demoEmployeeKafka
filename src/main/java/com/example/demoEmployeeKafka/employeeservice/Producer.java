package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.collection.EmployeeCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {

    private static String TOPIC = "test";


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(){

        EmployeeCollection employeeCollection = new EmployeeCollection();
        List<Employee> employees = employeeCollection.getEmployees();

        for (Employee employee: employees) {
            try {
                this.kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(employee));
            }catch (JsonProcessingException exp){
                System.out.println("error producing data");
            }
        }

    }


}
