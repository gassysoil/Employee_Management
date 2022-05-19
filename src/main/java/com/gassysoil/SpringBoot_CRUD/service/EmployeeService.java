package com.gassysoil.SpringBoot_CRUD.service;

import com.gassysoil.SpringBoot_CRUD.repository.EmployeeRepository;
import com.gassysoil.SpringBoot_CRUD.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	public List<Employee> findAllByOrderByLastNameAsc() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new RuntimeException("Employee id not found - " + theId);
		}
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}
