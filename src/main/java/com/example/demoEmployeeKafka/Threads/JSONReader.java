package com.example.demoEmployeeKafka.Threads;

import com.example.demoEmployeeKafka.Entity.Employee;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONReader extends Thread {

    public void run(){

        int count=0;

        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        Employee[] employee = new Employee[100];
        org.json.simple.JSONArray emplloyeeData = null;
        try (FileReader reader = new FileReader("/Users/rajeshwari/Downloads/employee.json")) {
            Object obj = parser.parse(reader);
            org.json.simple.JSONArray employeeData = (org.json.simple.JSONArray) obj;
            emplloyeeData = employeeData;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        for (Object object :emplloyeeData
                ) {
            org.json.simple.JSONObject employee2 = (org.json.simple.JSONObject) object;
            employee[count]= new Employee();
            String firstName = (String) employee2.get("firstName");
            employee[count].setFirstName(firstName);
            String lastName = (String) employee2.get("lastName");
            employee[count].setLastName(lastName);
            String dob = (String) employee2.get("dateOfBirth");
            Date dateOfBirth = null;
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yy").parse(dob);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }

            employee[count].setDateOfJoining(dateOfBirth);
            Integer experience = Integer.valueOf(employee2.get("experience").toString());

            employee[count].setExperience(experience);
            count++;

        }

    }

}
