package com.app.ecom.dto;

import com.app.ecom.model.UserRole;
import lombok.Data;

// Used to send safe, filtered user data back to the client.

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;     // this is a ENUM

    private AddressDTO address;
}
