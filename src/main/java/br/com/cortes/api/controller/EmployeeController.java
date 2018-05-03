package br.com.cortes.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cortes.api.dao.EmployeeDAO;
import br.com.cortes.api.model.Employee;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@PostMapping
	public Employee save(@Valid @RequestBody Employee object) {
		return employeeDao.save(object);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id) {
		Employee emp = employeeDao.findById(id);
		
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
			
		employeeDao.delete(emp);
		return ResponseEntity.ok().body(emp);
		
		
	}
	
	@GetMapping
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable(value = "id") Long id){
		Employee emp = employeeDao.findById(id);
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping
	public ResponseEntity<Employee> update(@Valid @RequestBody Employee object) {
		Employee emp = employeeDao.findById(object.getId());
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(object.getName());
		emp.setDesignation(object.getDesignation());
		emp.setExpertise(object.getExpertise());
		
		return ResponseEntity.ok().body(employeeDao.update(emp));
		
	}

}
