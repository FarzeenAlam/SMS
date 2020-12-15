package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer>{

}
