package com.dxctraining.computermgt.computer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "computers")
@Entity
public class Computer {

	@Id
	@GeneratedValue
	private Integer id;

	private int diskSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Computer that = (Computer) o;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}
}
