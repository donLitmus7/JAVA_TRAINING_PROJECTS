package com.litmus7.EmployeeDataFetch.DAO;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.litmus7.EmployeeDataFetch.Entity.EmployeePOJO;
import com.litmus7.EmployeeDataFetch.Util.LoggerCreate;
public class EmployeeDAO{
private String fileName;
public EmployeeDAO(String fileName){

this.fileName=fileName;

}


public List<EmployeePOJO> readAndReturn() throws Exception{
;


List<EmployeePOJO> employeepojoList=new ArrayList<>();
BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			while (line != null) {
			EmployeePOJO employeepojoObj=new EmployeePOJO();
			employeepojoObj.setId(line.split(",")[0]);
			employeepojoObj.setName(line.split(",")[1]);
				employeepojoList.add(employeepojoObj);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {LoggerCreate.logError("Exception-IO");
			e.printStackTrace();
		}
	
return employeepojoList;
}

}