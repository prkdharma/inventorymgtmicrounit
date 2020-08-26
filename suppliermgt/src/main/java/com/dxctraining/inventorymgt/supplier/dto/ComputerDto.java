package com.dxctraining.inventorymgt.supplier.dto;

public class ComputerDto {
	private int id;
	private int diskSize;

	public ComputerDto(int id, int diskSize) {
		this.id = id;
		this.diskSize = diskSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

}
