package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer>
{

	public List<Employee> findByCity(String city);
	public List<Employee> findBySalaryGreaterThan(int salary);
	
	@Query(value="select * from employee order by salary desc",nativeQuery=true)
	public List<Employee> sortEmpBysal();
	
	
}

