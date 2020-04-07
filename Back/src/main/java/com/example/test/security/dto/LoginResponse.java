package com.example.test.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private SuccessFailure status;
    private String message;
    private String error;

    public enum SuccessFailure {
        SUCCESS, FAILURE
    }

    public LoginResponse(SuccessFailure status, String message) {
        this.status = status;
        this.message = message;
    }
}
