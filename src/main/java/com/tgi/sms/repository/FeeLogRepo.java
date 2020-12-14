package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.FeeLog;

public interface FeeLogRepo extends JpaRepository<FeeLog, Integer>{

}
