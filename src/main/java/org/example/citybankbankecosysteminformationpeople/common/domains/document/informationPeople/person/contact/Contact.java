package org.example.citybankbankecosysteminformationpeople.common.domains.document.person.contact;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Contact implements Serializable
{
    private String phoneNumber;
    private String emailAddress;
}