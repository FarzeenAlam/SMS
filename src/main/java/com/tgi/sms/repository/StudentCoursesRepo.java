package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.StudentCourses;

public interface StudentCoursesRepo extends JpaRepository<StudentCourses, Integer> {

}
