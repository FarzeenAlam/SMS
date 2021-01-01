package com.tgi.sms.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tgi.sms.mongo.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

	List<Admin> findByName(String name);
	List<Admin> findByPassword(String password);
}
