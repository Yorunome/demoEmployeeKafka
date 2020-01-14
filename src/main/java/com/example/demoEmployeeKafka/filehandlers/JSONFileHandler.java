package com.example.demoEmployeeKafka.filehandlers;

import com.example.demoEmployeeKafka.Entity.Employee;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONFileHandler {

    public Employee[] objectCreation(){
        JSONParser parser = new JSONParser();
        Employee[] employee = new Employee[100];
        org.json.simple.JSONArray emplloyeeData = null;
        try (FileReader reader = new FileReader("/Users/rajeshwari/Downloads/employee.json")) {
            Object obj = parser.parse(reader);
            org.json.simple.JSONArray employeeData = (org.json.simple.JSONArray) obj;
            emplloyeeData = employeeData;
            //employeeData.forEach(emp -> parseEmployeeObject((JSONObject) emp));
            //emplloyeeData = (JSONArray) parser.parse(new FileReader("/Users/evurisasankreddy/Downloads/employee.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (Object object :emplloyeeData
                ) {
            org.json.simple.JSONObject employee2 = (org.json.simple.JSONObject) object;
            //Employee employee1 = new Employee();
            employee[count]= new Employee();
            String firstName = (String) employee2.get("firstName");
            employee[count].setFirstName(firstName);
            String lastName = (String) employee2.get("lastName");
            //employee1.setLastName(lastName);
            employee[count].setLastName(lastName);
            String dob = (String) employee2.get("dateOfBirth");
            Date dateOfBirth = null;
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yy").parse(dob);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            //employee1.setDateOfBirth(dateOfBirth);
            employee[count].setDateOfJoining(dateOfBirth);
            Integer experience = Integer.valueOf(employee2.get("experience").toString());
            //employee1.setExperience(experience);
            employee[count].setExperience(experience);
            count++;
            //MyCollection.employeeCollection.add(employee1);
        }
        return employee;
    }

}
