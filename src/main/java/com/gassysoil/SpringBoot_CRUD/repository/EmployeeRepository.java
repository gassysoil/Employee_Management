package com.gassysoil.SpringBoot_CRUD.repository;

import com.gassysoil.SpringBoot_CRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
}
