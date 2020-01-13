package com.example.demoEmployeeKafka.employeeservice;

import java.util.List;

public interface EmployeeServiceInterface {

    public <Emmployee> List<Emmployee> loadObjectList(Class<Emmployee> type, String fileName);


}
