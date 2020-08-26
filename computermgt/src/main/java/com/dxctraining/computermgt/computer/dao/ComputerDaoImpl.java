package com.dxctraining.computermgt.computer.dao;

import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.exceptions.ComputerNotFoundException;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ComputerDaoImpl implements IComputerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Computer findById(int id) {
        Computer computer = entityManager.find(Computer.class, id);
        if(computer==null){
            throw new ComputerNotFoundException("computer not found for id="+id);
        }
        return computer;
    }

    @Override
    public Computer save(Computer computer) {
        computer=entityManager.merge(computer);
        return computer;
    }

}
