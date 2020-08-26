package com.dxctraining.inventorymgt.supplier.util;

import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.supplier.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Component
public class SupplierUtil {
	public SupplierDto supplierDto(Supplier supplier,int compId,int compDiskSize, int phoneId,int phoneStorageSize)
	{
        SupplierDto dto=new SupplierDto(supplier.getId(),supplier.getName(),supplier.getPassword());
        dto.setCompId(compId);
        dto.setCompDiskSize(compDiskSize);
        dto.setPhoneId(phoneId);
        dto.setPhoneStorageSize(phoneStorageSize);
        return dto;
    }
	public SupplierDto supplierDtoComp(Supplier supplier,int compId,int compDiskSize)
	{
        SupplierDto dto=new SupplierDto(supplier.getId(),supplier.getName(),supplier.getPassword());
        dto.setCompId(compId);
        dto.setCompDiskSize(compDiskSize);
        return dto;
    }
	public SupplierDto supplierDtoPhone(Supplier supplier,int phoneId,int phoneStorageSize)
	{
        SupplierDto dto=new SupplierDto(supplier.getId(),supplier.getName(),supplier.getPassword());
        dto.setPhoneId(phoneId);
        dto.setPhoneStorageSize(phoneStorageSize);
        return dto;
    }
}
