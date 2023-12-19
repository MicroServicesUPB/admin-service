package com.upb.adminservice.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    
}
