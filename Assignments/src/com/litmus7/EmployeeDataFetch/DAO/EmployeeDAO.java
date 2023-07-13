package com.litmus7.EmployeeDataFetch.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.EmployeeDataFetch.Entity.EmployeePOJO;
import com.litmus7.EmployeeDataFetch.exception.DataProcessingException;
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
		}
		catch (FileNotFoundException e) {
			throw new DataProcessingException("Exception occurd file not found",e);
		}
	
return employeepojoList;
}

}