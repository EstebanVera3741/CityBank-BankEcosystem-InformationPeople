package org.example.citybankbankecosysteminformationpeople.common.domains.document.person.address;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable
{
    private String nationality;
    private String state;
    private String city;
    private String street;
    private String postalCode;
}