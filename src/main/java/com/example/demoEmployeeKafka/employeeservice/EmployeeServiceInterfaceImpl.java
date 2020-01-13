package com.example.demoEmployeeKafka.employeeservice;

import com.example.demoEmployeeKafka.Entity.Employee;
import com.example.demoEmployeeKafka.employeerepository.EmployeeRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepositoryInterface employeeRepositoryInterface;

    @Override
    public Employee save(Employee employee) {
        return employeeRepositoryInterface.save(employee);
    }
    @Transactional
    public void run(String... args) throws Exception
    {
        try
        {
            File file = new File("/Users/simrankumarisah/Downloads/employee.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(file);
                System.out.println(employee);
            } catch (JAXBException e) {
                e.printStackTrace();
            }


        }
}
