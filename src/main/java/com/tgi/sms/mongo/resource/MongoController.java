package com.tgi.sms.mongo.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.sms.mongo.model.Admin;
import com.tgi.sms.mongo.repository.AdminRepository;

@RestController
public class MongoController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final AdminRepository adminrepo;

	public MongoController(AdminRepository adminrepo) {
		this.adminrepo = adminrepo;
	}

	//Get all records
	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		LOG.info("Getting all the data");
		return adminrepo.findAll();
	}

	//Get record by id
	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable String id) {
		LOG.info("Getting one admin with id: {}", id);
		return adminrepo.findById(id).orElse(null);
	}
	
	//Get record by name
	@GetMapping("/name/{name}")
	public List<Admin> getAdminbyName(@PathVariable String name) {
		LOG.info("Getting one admin with name: {}", name);
		return adminrepo.findByName(name);
	}
	
	//Get record by password
	@GetMapping("/pass/{password}")
	public List<Admin> getAdminbyPassword(@PathVariable String password) {
		LOG.info("Getting one admin with password: {}", password);
		return adminrepo.findByPassword(password);
	}
	
	//get record by name and password
	@GetMapping("/try/{name}/{pass}")
	public Admin getbyNamePassword(@PathVariable(name = "name") String name, @PathVariable(name = "pass")String pass){
		Admin admin = null;
		Admin topost = null;
		List<Admin> a = adminrepo.findAll();
		for(int i = 0; i < a.size(); i++) {
			admin = a.get(i);
			if(admin.getName().equals(name) && admin.getPassword().equals(pass)) {
				topost = admin;
			}
		}
		return topost;
	}

	//add a new record
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		LOG.info("Saving admin");
		return adminrepo.save(admin);
	}

	//update an existing record
	@PutMapping("/")
	public void updateAdmin(@RequestBody Admin newadmin) {
		String id = newadmin.getId();
		if(adminrepo.findById(id).isPresent()) {
			Admin admin = adminrepo.findById(id).orElse(null);
			admin.setId(newadmin.getId());
			admin.setAccount_type(newadmin.getAccount_type());
			admin.setEmail(newadmin.getEmail());
			admin.setName(newadmin.getName());
			admin.setPassword(newadmin.getPassword());
			adminrepo.save(admin);
			LOG.info("Updated");
		}
		else
			LOG.info("DATA NOT FOUND!");
	}
	
	//delete a record
	@DeleteMapping("del/{id}")
	public void deleteAdmin(@PathVariable String id) {
		if(adminrepo.findById(id).isPresent()) {
			adminrepo.deleteById(id);
			LOG.info("Deleted!");
		}
		else
			LOG.info("DATA NOT FOUND");
	}
}