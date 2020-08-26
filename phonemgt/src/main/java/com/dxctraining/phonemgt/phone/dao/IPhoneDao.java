package com.dxctraining.phonemgt.phone.dao;

import com.dxctraining.phonemgt.phone.entities.Phone;

public interface IPhoneDao {

    Phone findById(int id);

    Phone save(Phone phone);


}
