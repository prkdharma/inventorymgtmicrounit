package com.dxctraining.inventorymgt.supplier.dto;

public class PhoneDto {
	private int id;
	private int storageSize;
	public PhoneDto(int id,int storageSize)
	{
		this.id=id;
		this.storageSize=storageSize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStorageSize() {
		return storageSize;
	}
	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}
    
}
