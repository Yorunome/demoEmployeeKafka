package com.example.demoEmployeeKafka.collection;

import com.example.demoEmployeeKafka.Entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EmployeeCollection {

    public static List<Employee> employeeCollection = new ArrayList<Employee>();

    private String firstName ;
    private String lastName ;
    private Date dateOfJoining ;
    private double experience ;

    public String getFirstName(int index) {
        return employeeCollection.get(index).getFirstName();
    }

    public String getLastName(int index) {
        return employeeCollection.get(index).getLastName();
    }

    public Date getDateOfJoining(int index) {
        return employeeCollection.get(index).getDateOfJoining();
    }

    public double getExperience(int index) {
        return employeeCollection.get(index).getExperience();
    }

    public void setEmployees(Employee[] emp){

        employeeCollection.addAll(Arrays.asList(emp));
        System.out.println(employeeCollection.size());
//        e1.forEach(e -> {
//            System.out.println("First Name : " + e.getFirstName() + ", Last Name : " + e.getLastName());
//        });
    }

    public List<Employee> getEmployees(){
        return employeeCollection;
    }

    @Override
    public String toString() {
        return "EmployeeCollection{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", experience=" + experience +
                '}';
    }
}
