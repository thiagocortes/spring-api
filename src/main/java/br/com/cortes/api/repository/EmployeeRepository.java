package br.com.cortes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cortes.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
