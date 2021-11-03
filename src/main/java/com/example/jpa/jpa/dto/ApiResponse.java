package com.example.jpa.jpa.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private int code;
    private Object object;
    private boolean success;

    public ApiResponse(String message, int code, Object object, boolean success) {
        this.message = message;
        this.code = code;
        this.object = object;
        this.success = success;
    }
}
