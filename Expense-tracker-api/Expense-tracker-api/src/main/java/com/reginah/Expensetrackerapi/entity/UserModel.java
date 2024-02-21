package com.reginah.Expensetrackerapi.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserModel {
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Long age = 0L; //if the user does not provide age then it will automatically be set to zero
}
