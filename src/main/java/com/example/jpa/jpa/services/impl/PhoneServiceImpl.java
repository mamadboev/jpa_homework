package com.example.jpa.jpa.services.impl;

import com.example.jpa.jpa.dto.ApiResponse;
import com.example.jpa.jpa.dto.PhoneForm;
import com.example.jpa.jpa.dto.PhoneList;
import com.example.jpa.jpa.entity.Phone;
import com.example.jpa.jpa.repository.PhoneRepository;
import com.example.jpa.jpa.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public ApiResponse list(Long id, Pageable pageable) {
        if (id == null) {
            Page<PhoneList> lists = phoneRepository.findAll(pageable).map(PhoneList::getList);
            return new ApiResponse("Phone list", 200, lists, true);
        } else {
            Phone phone = phoneRepository.findById(id).orElse(null);
            if (phone == null) {
                return new ApiResponse("Phone not found list", 404, null, false);
            }
            return new ApiResponse("Phone one list", 200, phone, true);
        }
    }

    @Override
    public ApiResponse add(PhoneForm phoneForm) {
        Phone phone = new Phone();
        phone.setInfo(phoneForm.getInfo());
        phone.setModel(phoneForm.getModel());
        phone.setMacAddress(phoneForm.getMacAddress());
        phone.setName(phoneForm.getName());
        phoneRepository.save(phone);
        return new ApiResponse("Phone add", 200, phone, true);
    }

    @Override
    public ApiResponse update(Long id, PhoneForm phoneForm) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        if (phone == null) {
            return new ApiResponse("Phone not found", 404, null, false);
        }
        phone.setInfo(phoneForm.getInfo());
        phone.setModel(phoneForm.getModel());
        phone.setName(phoneForm.getName());
        phone.setMacAddress(phoneForm.getMacAddress());
        phoneRepository.save(phone);
        return new ApiResponse("Phone update!", 200, phone, true);
    }

    @Override
    public ApiResponse delete(Long id) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        if (phone == null) {
            return new ApiResponse("Phone not found", 404, null, false);
        }
        phoneRepository.delete(phone);
        return new ApiResponse("Phone deleted", 200, null, true);
    }
}
