package com.example.test.security.dto;

import com.example.test.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserProfile {
    private Long id;
    private String username;

    List<Role> roles = new ArrayList<>();


}
