package com.litmus7.EmployeeDataFetch.exception;

public class DataProcessingException extends Exception{
public DataProcessingException(String message) {
	super(message);
}
public DataProcessingException(String message,Throwable err) {
	super(message,err);
}
}
