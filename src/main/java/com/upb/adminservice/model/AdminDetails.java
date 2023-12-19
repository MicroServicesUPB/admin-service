package com.upb.adminservice.model;

import lombok.Data;
import lombok.NonNull;


@Data
public class AdminDetails {
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
}


