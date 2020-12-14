package com.tgi.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class Building {

	@Id
	@GeneratedValue
	@Column(name="bld_id")
	private int BuildingId;
	
	@Column(name="block_name")
	private String BuildingName;
	
	@OneToOne
	@JoinColumn(name="dept_id", referencedColumnName="dept_id")
	private Department department;

	public Building() {
		super();
	}

	public int getBuildingId() {
		return BuildingId;
	}

	public void setBuildingId(int buildingId) {
		BuildingId = buildingId;
	}

	public String getBuildingName() {
		return BuildingName;
	}

	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Building [BuildingId=" + BuildingId + ", BuildingName=" + BuildingName + ", department=" + department
				+ "]";
	}
	
	
}
