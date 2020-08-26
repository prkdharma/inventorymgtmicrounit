package com.dxctraining.computermgt.computer.dao;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerDao {

    Computer findById(int id);

    Computer save(Computer computer);


}
