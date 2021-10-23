package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int eid;
	private String ename;
	private int salary;
	private String city;
	
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", city=" + city + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
