package br.com.cortes.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cortes.api.model.Employee;
import br.com.cortes.api.repository.EmployeeRepository;


@Service
public class EmployeeDAO {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee save(Employee object) {
		return employeeRepository.save(object);
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Employee findById(Long id) {
		Optional<Employee> obj = employeeRepository.findById(id);
		return obj.get();
	}
	
	public void delete(Employee object) {
		employeeRepository.delete(object);
	}
	
	public Employee update(Employee object) {
		return employeeRepository.save(object);
	}

}
