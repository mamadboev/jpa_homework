package com.example.jpa.jpa.services;

import com.example.jpa.jpa.dto.ApiResponse;
import com.example.jpa.jpa.dto.PhoneForm;
import org.springframework.data.domain.Pageable;


public interface PhoneService {
    ApiResponse list(Long id, Pageable pageable);

    ApiResponse add(PhoneForm phoneForm);

    ApiResponse update(Long id, PhoneForm phoneForm);

    ApiResponse delete(Long id);
}
