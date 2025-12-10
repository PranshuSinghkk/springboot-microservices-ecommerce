package com.app.ecom.dto;

import lombok.Data;

// Used to receive only the allowed user input from the client.

@Data
public class UserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private AddressDTO address;
}
