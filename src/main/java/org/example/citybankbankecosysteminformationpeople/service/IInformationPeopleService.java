package org.example.citybankbankecosysteminformationpeople.service;

import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.springframework.http.ResponseEntity;

public interface IInformationPeopleService
{
    public ResponseEntity<InformationResponse> getInformationPeople
            (String personIdentification);
    ResponseEntity<InformationResponse> saveInformationPeople
            (InformationPeopleDocument informationPeopleDocument);
}