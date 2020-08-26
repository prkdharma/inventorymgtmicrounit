package com.dxctraining.phonemgt.phone.service;

import com.dxctraining.phonemgt.phone.dao.IPhoneDao;
import com.dxctraining.phonemgt.phone.entities.Phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService {

   @Autowired
    private IPhoneDao dao;

    @Override
    public Phone findById(int id) {
        Phone phone=dao.findById(id);
        return phone;
    }

    @Override
    public Phone save(Phone phone) {
    	int id=phone.getId();
    	Phone phon=dao.findById(id);
        phon=dao.save(phon);
        return phon;
    }

}
