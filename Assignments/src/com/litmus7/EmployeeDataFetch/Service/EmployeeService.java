package com.litmus7.EmployeeDataFetch.Service;

import java.util.List;

import com.litmus7.EmployeeDataFetch.DAO.EmployeeDAO;
import com.litmus7.EmployeeDataFetch.Entity.EmployeePOJO;
import com.litmus7.EmployeeDataFetch.Util.LoggerCreate;
public class EmployeeService{
public List<EmployeePOJO> getEmployeeDetails(String textFileName) throws Exception
{

LoggerCreate.logInfo("Method invoked-getEmployeeDetails ");
List<EmployeePOJO> employeeList;
EmployeeDAO employeeDao=new EmployeeDAO(textFileName);

return employeeDao.readAndReturn();
}

}