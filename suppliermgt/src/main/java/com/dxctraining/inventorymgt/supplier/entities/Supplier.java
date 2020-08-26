package com.dxctraining.inventorymgt.supplier.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	private int compId;
	private int phoneId;
	public Supplier(String name, String password,int compId,int phoneId) {
		this.name = name;
		this.password = password;
		this.compId=compId;
		this.phoneId=phoneId;
	}
	public Supplier(String name, String password) {
		this.name = name;
		this.password = password;
		
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public Supplier() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof Supplier)) {
			return false;
		}
		Supplier that = (Supplier)o;
		boolean isequals = this.id == that.id;
		return isequals;
		
	}
	

}
