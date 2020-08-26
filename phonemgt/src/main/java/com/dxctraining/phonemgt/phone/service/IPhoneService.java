package com.dxctraining.phonemgt.phone.service;

import com.dxctraining.phonemgt.phone.entities.Phone;

public interface IPhoneService {

    Phone findById(int id);

    Phone save(Phone phone);

}
