package com.dxctraining.phonemgt.phone.dao;

import com.dxctraining.phonemgt.exceptions.PhoneNotFoundException;
import com.dxctraining.phonemgt.phone.entities.Phone;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PhoneDaoImpl implements IPhoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Phone findById(int id) {
        Phone phone = entityManager.find(Phone.class, id);
        if(phone==null){
            throw new PhoneNotFoundException("phone not found for id="+id);
        }
        return phone;
    }

    @Override
    public Phone save(Phone phone) {
        phone=entityManager.merge(phone);
        return phone;
    }

}
