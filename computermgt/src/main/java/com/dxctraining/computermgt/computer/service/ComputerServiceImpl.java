package com.dxctraining.computermgt.computer.service;

import com.dxctraining.computermgt.computer.dao.IComputerDao;
import com.dxctraining.computermgt.computer.entities.Computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ComputerServiceImpl implements IComputerService {

   @Autowired
    private IComputerDao dao;

    @Override
    public Computer findById(int id) {
        Computer department=dao.findById(id);
        return department;
    }

    @Override
    public Computer save(Computer computer) {
    	int id=computer.getId();
    	Computer comp=dao.findById(id);
        comp=dao.save(comp);
        return comp;
    }

}
