package com.dxctraining.phonemgt.phone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "phones")
@Entity
public class Phone {

	@Id
	@GeneratedValue
	private Integer id;
    private int storageSize;
	

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Phone that = (Phone) o;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}
}
