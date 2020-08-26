package com.dxctraining.phonemgt.phone.controllers;

import com.dxctraining.phonemgt.phone.dto.PhoneDto;
import com.dxctraining.phonemgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.phonemgt.phone.entities.Phone;
import com.dxctraining.phonemgt.phone.service.IPhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/computers")
public class PhoneController {

    @Autowired
    private IPhoneService service;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneDto add(@RequestBody CreatePhoneRequest requestData) {
        Phone phone = new Phone();
        phone.setStorageSize(requestData.getStorageSize());
        phone = service.save(phone);
        PhoneDto response = toDto(phone);
        return response;
    }

    @GetMapping("/get/{id}")
    public PhoneDto getPhone(@PathVariable("id") int id) {
        Phone phone = service.findById(id);
        PhoneDto response = toDto(phone);
        return response;
    }

    public PhoneDto toDto(Phone phone) {
        PhoneDto dto = new PhoneDto();
        dto.setId(phone.getId());
        dto.setStorageSize(phone.getStorageSize());
        return dto;
    }

}
