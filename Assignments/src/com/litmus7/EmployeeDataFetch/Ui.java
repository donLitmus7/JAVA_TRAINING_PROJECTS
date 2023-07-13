package com.litmus7.EmployeeDataFetch;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.litmus7.EmployeeDataFetch.Entity.EmployeePOJO;
import com.litmus7.EmployeeDataFetch.Service.EmployeeService;
import com.litmus7.EmployeeDataFetch.Util.LoggerCreate;
import com.litmus7.EmployeeDataFetch.exception.DataProcessingException;
import com.litmus7.EmployeeDataFetch.exception.InvalidInputException;
public class Ui{
public static void main(String args[]) throws Exception
{
//String filePath=args[0];
FileReader reader=new FileReader("D:\\RA72023\\training_workspace\\Assignments\\src\\com\\litmus7\\EmployeeDataFetch\\config\\config.properties");  
    
    Properties properties=new Properties();  
    properties.load(reader);  
    Scanner scanner = new Scanner(System.in);
String filePath=properties.getProperty("filename");
LoggerCreate.logInfo("started running with file name"+filePath);
EmployeeService employeeservice=new EmployeeService();
List<EmployeePOJO> employeeList;

	outer:
	while(true){
	System.out.println("\nMENU");
	System.out.println("1.Display Details:");
	System.out.println("2.Exit");
	LoggerCreate.logInfo("MENU displayed");
	try {
	switch(scanner.nextInt())
	{
	case 1:employeeList=employeeservice.getEmployeeDetails(filePath);
		for (EmployeePOJO employeepojo:employeeList )
		{ System.out.println("\n\n\n");
	       System.out.println(employeepojo);
		LoggerCreate.logInfo("Printed");
		}
		break;
	
	case 2:LoggerCreate.logInfo("Exit invoked");
	break outer;
	 default :throw new InvalidInputException("Invaid Input Exception");
		
		
	
	}
	
	}
	catch(DataProcessingException e)
	{
		LoggerCreate.logError(e.getMessage());	
		System.out.println("Enter a Valid filepath:");
		filePath=scanner.next();
		continue;
	}
	catch(InvalidInputException e)
	{System.out.println("Enter a valid input");
		LoggerCreate.logError(e.getMessage());	
		
		continue;
	}
	}

}}