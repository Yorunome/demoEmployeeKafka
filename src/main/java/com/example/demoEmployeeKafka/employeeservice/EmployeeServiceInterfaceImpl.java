package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Threads.CSVReader;
import com.example.demoEmployeeKafka.Threads.JSONReader;
import com.example.demoEmployeeKafka.Threads.XMLReader;
import com.example.demoEmployeeKafka.employeerepository.EmployeeRepositoryInterface;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepositoryInterface employeeRepositoryInterface;

<<<<<<< HEAD

    @Override
    public <Emmployee> List<Emmployee> loadObjectList(Class<Emmployee> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource("/User/naveenrajshukla/Downloads/employee.csv").getFile();
            MappingIterator<Emmployee> readValues = mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
           // logger.error("Error occurred while loading object list from file " + fileName, e);

            System.out.println("error occurred");
            return Collections.emptyList();
=======
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
>>>>>>> aea5a9b74cbac29137234e049fc05672235ae62a
        }
    }
}
