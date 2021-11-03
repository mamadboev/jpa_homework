package com.example.jpa.jpa.controllers;

import com.example.jpa.jpa.dto.PhoneForm;
import com.example.jpa.jpa.services.impl.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private PhoneServiceImpl phoneService;

    @GetMapping(value = {"/list", "/list/{id}"})
    public ResponseEntity list(Pageable pageable, @PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(phoneService.list(id, pageable));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PhoneForm phoneForm) {
        return ResponseEntity.ok(phoneService.add(phoneForm));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity add(@PathVariable("id") Long id, @RequestBody PhoneForm phoneForm) {
        return ResponseEntity.ok(phoneService.update(id, phoneForm));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity add(@PathVariable("id") Long id) {
        return ResponseEntity.ok(phoneService.delete(id));
    }

}
