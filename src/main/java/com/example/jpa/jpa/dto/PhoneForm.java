package com.example.jpa.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneForm {
    private String name;
    private String model;
    private String macAddress;
    private String info;
}
