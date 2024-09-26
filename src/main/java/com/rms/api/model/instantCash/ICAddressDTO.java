package com.rms.api.model.instantCash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ICAddressDTO {

    @NotEmpty
    private String addressLine1;
    private String addressLine2;
    //Mandatory if receiving country is Bangladesh.
    private String district;
    @NotEmpty
    private String city;
    private String postCode;
    private String state;

    //Mandatory if receiving country is UAE.
    private String country;
}
