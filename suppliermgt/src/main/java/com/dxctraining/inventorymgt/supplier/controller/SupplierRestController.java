package com.dxctraining.inventorymgt.supplier.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.dxctraining.inventorymgt.supplier.dto.ComputerDto;
import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.PhoneDto;
import com.dxctraining.inventorymgt.supplier.dto.SupplierDto;
import com.dxctraining.inventorymgt.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
import com.dxctraining.inventorymgt.supplier.util.SupplierUtil;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	@Autowired
    private SupplierUtil supplierUtil;

    @Autowired
    private RestTemplate restTemplate;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto createSupplier(@RequestBody CreateSupplierRequest supplier) {
		int compId = supplier.getCompId();
		int phoneId = supplier.getPhoneId();
		Supplier s1 = new Supplier(supplier.getName(), supplier.getPassword(),compId,phoneId);
		s1 = service.addSupplier(s1);
		ComputerDto computer = fetchFromComputerAppById(compId);
		PhoneDto phone= fetchFromPhoneAppById(phoneId);
        SupplierDto response = supplierUtil.supplierDto(s1, compId, computer.getDiskSize(),phoneId,phone.getStorageSize());
        return response;
	}

	@GetMapping("/get/computer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getComputerBySuppId(@PathVariable("id")int id) {
		Supplier s1 = service.findById(id);
		 int computerId = s1.getCompId();
	        ComputerDto computer = fetchFromComputerAppById(computerId);
	        SupplierDto response = supplierUtil.supplierDtoComp(s1,computerId, computer.getDiskSize() );
		return response;
	}
	@GetMapping("/get/phone/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getPhoneBySuppId(@PathVariable("id")int id) {
		Supplier s1 = service.findById(id);
		 int phoneId = s1.getPhoneId();
	        PhoneDto phone = fetchFromPhoneAppById(phoneId);
	        SupplierDto response = supplierUtil.supplierDtoPhone(s1,phoneId, phone.getStorageSize() );
		return response;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getSupplier(@PathVariable("id")int id) {
		Supplier s1 = service.findById(id);
		int compId = s1.getCompId();
		int phoneId = s1.getPhoneId();
		ComputerDto computer = fetchFromComputerAppById(compId);
		PhoneDto phone= fetchFromPhoneAppById(phoneId);
	        SupplierDto response = supplierUtil.supplierDto(s1, compId, computer.getDiskSize(),phoneId,phone.getStorageSize());
		return response;
	}
	
	@GetMapping
    public List<SupplierDto> fetchAll() {
        List<Supplier> list = service.listAll();
        List<SupplierDto>response=new ArrayList<>();
        for (Supplier supplier:list){
        	int compId = supplier.getCompId();
    		int phoneId = supplier.getPhoneId();
    		ComputerDto computer = fetchFromComputerAppById(compId);
    		PhoneDto phone= fetchFromPhoneAppById(phoneId);
            SupplierDto supplierl = supplierUtil.supplierDto(supplier, compId, computer.getDiskSize(),phoneId,phone.getStorageSize());
            response.add(supplierl);
        }
        return response;
    }
	
	 /**
     * uri is /suppliers/update
     */
    @PutMapping("/update")
    public SupplierDto updateEmployee(@RequestBody UpdateSupplierRequest requestData) {
        String name = requestData.getName();
        String password = requestData.getPassword();
        int id = requestData.getId();
        Supplier supplier = service.findById(id);
        supplier.setName(name);
        supplier.setPassword(password);
        supplier = service.updateSupplier(supplier);
        int compId = supplier.getCompId();
		int phoneId = supplier.getPhoneId();
		ComputerDto computer = fetchFromComputerAppById(compId);
		PhoneDto phone= fetchFromPhoneAppById(phoneId);

        SupplierDto response = supplierUtil.supplierDto(supplier,compId, computer.getDiskSize(),phoneId,phone.getStorageSize());
        return response;
    }

    @GetMapping("/authenticate/{id}/{password}")
    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password) {
        boolean result = service.authentication(id, password);
        return result;
    }


	 public ComputerDto fetchFromComputerAppById(int compId) {
	        String url = "http://localhost:8586/computers/get/" + compId;
	        // here we are creating get request
	        ComputerDto dto = restTemplate.getForObject(url, ComputerDto.class);
	        return dto;
	    }
	 public PhoneDto fetchFromPhoneAppById(int phoneId) {
	        String url = "http://localhost:8586/phones/get/" + phoneId;
	        // here we are creating get request
	        PhoneDto dto = restTemplate.getForObject(url, PhoneDto.class);
	        return dto;
	    }
}