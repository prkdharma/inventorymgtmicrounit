package com.dxctraining.inventorymgt.supplier.dto;

public class SupplierDto {
	private int id;
	private String name;
	private String password;
	private int compId;
	private int compDiskSize;
	private int phoneId;
	private int phoneStorageSize;
    public SupplierDto(int id,String name,String password)
    {
    	this.id=id;
    	this.name=name;
    	this.password=password;
    }
    public SupplierDto()
    {
    	
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
	public int getCompDiskSize() {
		return compDiskSize;
	}
	public void setCompDiskSize(int compDiskSize) {
		this.compDiskSize = compDiskSize;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public int getPhoneStorageSize() {
		return phoneStorageSize;
	}
	public void setPhoneStorageSize(int phoneStorageSize) {
		this.phoneStorageSize = phoneStorageSize;
	}
    
}
