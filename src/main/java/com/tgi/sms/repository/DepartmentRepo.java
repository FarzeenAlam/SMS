package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
