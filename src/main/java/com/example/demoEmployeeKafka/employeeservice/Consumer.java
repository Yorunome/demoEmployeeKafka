package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class Consumer {

    ObjectMapper objectMapper = new ObjectMapper();

    //private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) throws IOException {
        try{
            System.out.println(objectMapper.readValue(message, Employee.class));
        }catch (IOException exp){
            System.out.println("error while consuming messages");
        }

    }
}