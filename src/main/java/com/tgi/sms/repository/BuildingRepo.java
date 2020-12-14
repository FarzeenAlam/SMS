package com.tgi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi.sms.model.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer> {

}
