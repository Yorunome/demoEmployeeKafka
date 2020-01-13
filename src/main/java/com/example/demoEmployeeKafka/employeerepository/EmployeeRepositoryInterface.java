package com.example.demoEmployeeKafka.employeerepository;

import com.example.demoEmployeeKafka.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryInterface extends CrudRepository<Employee,String> {



}
