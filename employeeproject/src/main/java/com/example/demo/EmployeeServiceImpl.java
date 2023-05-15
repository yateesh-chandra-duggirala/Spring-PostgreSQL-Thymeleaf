package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override public List<Employee> getAllEmployee()
	{
		return empRepo.findAll();
	}
	
	@Override
	public void save(Employee employee)
	{
		empRepo.save(employee);
	}
	
	@Override
	public Employee getById(Long id)
	{
		Optional<Employee> optional = empRepo.findById(id);
		Employee employee = null;
		if(optional.isPresent())
			employee = optional.get();
		else
			throw new RuntimeException("Employee not found for the ID" + id);
		return employee;
	}
	
	
	@Override
	public void deleteViaId(long id) {
		empRepo.deleteById(id);
	}
}
