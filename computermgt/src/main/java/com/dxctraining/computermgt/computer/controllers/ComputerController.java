package com.dxctraining.computermgt.computer.controllers;

import com.dxctraining.computermgt.computer.dto.CreateComputerRequest;
import com.dxctraining.computermgt.computer.dto.ComputerDto;
import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.computer.service.IComputerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private IComputerService service;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerDto add(@RequestBody CreateComputerRequest requestData) {
        Computer computer = new Computer();
        computer.setDiskSize(requestData.getDiskSize());
        computer = service.save(computer);
        ComputerDto response = toDto(computer);
        return response;
    }

    @GetMapping("/get/{id}")
    public ComputerDto getComputer(@PathVariable("id") int id) {
        Computer computer = service.findById(id);
        ComputerDto response = toDto(computer);
        return response;
    }

    public ComputerDto toDto(Computer computer) {
        ComputerDto dto = new ComputerDto();
        dto.setId(computer.getId());
        dto.setDiskSize(computer.getDiskSize());
        return dto;
    }

}
