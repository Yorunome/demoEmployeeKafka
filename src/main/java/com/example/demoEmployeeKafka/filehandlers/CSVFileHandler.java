package com.example.demoEmployeeKafka.filehandlers;

import com.example.demoEmployeeKafka.Entity.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVFileHandler {

    public Employee[] objectCreation(){
        Employee[] employee = new Employee[100];
        String csvFile = "/Users/rajeshwari/Downloads/employee.csv";
        BufferedReader br = null;
        String line = "";
        int count=0;
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                employee[count] = new Employee();
                // use comma as separator
                String[] ReadFromCSV = line.split(cvsSplitBy);
                //System.out.println(ReadFromCSV[0]);
                employee[count].setFirstName(ReadFromCSV[0]);
                employee[count].setLastName(ReadFromCSV[1]);
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ReadFromCSV[2]);
                employee[count].setDateOfJoining(date);
                Double d = Double.parseDouble(ReadFromCSV[3]);
                employee[count].setExperience(d);
                count++;
                //return employee;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException p) {
            p.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return employee;
    }

}
