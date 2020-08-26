package com.dxctraining.computermgt.computer.service;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerService {

    Computer findById(int id);

    Computer save(Computer computer);

}
