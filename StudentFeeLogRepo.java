package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.StudentFeeLog;

public interface StudentFeeLogRepo extends JpaRepository<StudentFeeLog, Integer>{

}
