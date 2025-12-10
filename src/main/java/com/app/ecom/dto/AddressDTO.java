package com.app.ecom.dto;

import lombok.Data;

// A clean, controlled version of the user’s address used in both request and response.

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
