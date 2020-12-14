package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
