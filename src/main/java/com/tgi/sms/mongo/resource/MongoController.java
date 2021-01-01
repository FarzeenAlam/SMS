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
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		LOG.info("Getting all the data");
		return adminrepo.findAll();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable String id) {
		LOG.info("Getting one admin with id: {}", id);
		return adminrepo.findById(id).orElse(null);
	}
	
	@GetMapping("/name/{name}")
	public List<Admin> getAdminbyName(@PathVariable String name) {
		LOG.info("Getting one admin with name: {}", name);
		return adminrepo.findByName(name);
	}
	
	@GetMapping("/pass/{password}")
	public List<Admin> getAdminbyPassword(@PathVariable String password) {
		LOG.info("Getting one admin with password: {}", password);
		return adminrepo.findByPassword(password);
	}
	
	@RequestMapping("/try")
	public Admin getbyNamePassword(){
		String name = new String("Zeen");
		String password = new String("1234");
		Admin admin = null;
		List<Admin> a = adminrepo.findAll();
		for(int i = 0; i < a.size(); i++) {
			admin = a.get(i);
			if(admin.getName().equals(name)) {
				if(admin.getPassword().equals(password))
					break;
			}
		}
		return admin;
	}

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		LOG.info("Saving admin");
		return adminrepo.save(admin);
	}

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
