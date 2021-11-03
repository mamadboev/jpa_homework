package com.example.jpa.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneItem {
    private String name;
    private String model;
    private String mac_address;
    private String info;
}
