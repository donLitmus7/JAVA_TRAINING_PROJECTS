package com.litmus7.EmployeeDataFetch.Service;

import java.util.List;

import com.litmus7.EmployeeDataFetch.DAO.EmployeeDAO;
import com.litmus7.EmployeeDataFetch.Entity.EmployeePOJO;
import com.litmus7.EmployeeDataFetch.Util.LoggerCreate;
import com.litmus7.EmployeeDataFetch.exception.DataProcessingException;
public class EmployeeService{
public List<EmployeePOJO> getEmployeeDetails(String textFileName) throws Exception
{EmployeeDAO employeeDao;
	
	try {

LoggerCreate.logInfo("Method invoked-getEmployeeDetails ");
List<EmployeePOJO> employeeList;
employeeDao=new EmployeeDAO(textFileName);
	}
	catch(DataProcessingException e)
	{
		throw new DataProcessingException("issue in loading file");
	}
return employeeDao.readAndReturn();
}

}