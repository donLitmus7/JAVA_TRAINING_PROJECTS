package com.litmus7.EmployeeDataFetch.Entity;

public class EmployeePOJO{
private String id;
private String name;
public void setId(String id)
{
this.id=id;

}
public void setName(String name)
{
this.name=name;

}
 public String toString() {
        return "ID"+this.id + " \nNAME: " + this.name;


}


}