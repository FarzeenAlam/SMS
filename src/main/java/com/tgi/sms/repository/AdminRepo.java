package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{

}
