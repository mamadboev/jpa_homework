package com.example.jpa.jpa.dto;

import com.example.jpa.jpa.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneList {
    private Long id;
    private String name;
    private String model;
    private String info;

    public static PhoneList getList(Phone phone) {
        PhoneList list = new PhoneList();
        list.setName(phone.getName());
        list.setId(phone.getId());
        list.setInfo(phone.getInfo());
        list.setModel(phone.getModel());
        return list;
    }
}
