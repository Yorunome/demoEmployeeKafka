//package com.example.demoEmployeeKafka.employeeservice;
//
//
//import com.example.demoEmployeeKafka.Entity.Employee;
//import com.example.demoEmployeeKafka.Threads.CSVReader;
//import com.example.demoEmployeeKafka.Threads.JSONReader;
//import com.example.demoEmployeeKafka.Threads.XMLReader;
//import com.example.demoEmployeeKafka.employeerepository.EmployeeRepositoryInterface;
//import com.fasterxml.jackson.databind.MappingIterator;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//
//import javax.transaction.Transactional;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import java.io.File;
//
//import java.io.File;
//import java.util.Collections;
//import java.util.List;
//
//
//@Service
//public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {
//
//    @Autowired
//    EmployeeRepositoryInterface employeeRepositoryInterface;
//
//
//    @Transactional
//    public void run(String... args) throws Exception {
//        try {
//            File file = new File("/Users/rajeshwari/Downloads/employee.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(employee);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    @Override
//    public <Employee> List<Employee> loadObjectList(Class<Employee> type, String fileName) {
//        try {
//            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
//            CsvMapper mapper = new CsvMapper();
//            File file = new ClassPathResource("/User/rajeshwari/Downloads/employee.csv").getFile();
//            MappingIterator<Employee> readValues = mapper.reader(type).with(bootstrapSchema).readValues(file);
//            return readValues.readAll();
//        } catch (Exception e) {
//            // logger.error("Error occurred while loading object list from file " + fileName, e);
//        }
//        System.out.println("file successfully read");
//        return Collections.emptyList();
//    }
//}
//
//
//
//    @Override
//    public void fileReaders() {
//
//        try {
//        CSVReader csvReader = new CSVReader();
//        csvReader.start();
//        XMLReader xmlReader = new XMLReader();
//        xmlReader.start();
//        JSONReader jsonReader = new JSONReader();
//        jsonReader.start();
//
//        csvReader.join();
//        xmlReader.join();
//        jsonReader.join();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//    }
//
//}
