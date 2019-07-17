package com.tw.apistackbase.repo;

import com.tw.apistackbase.core.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
