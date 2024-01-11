package org.example.citybankbankecosysteminformationpeople.webApi;

import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.constant.endPoint.IInformationPeopleEndPoint;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IInformationPeopleApi
{
    @GetMapping(IInformationPeopleEndPoint.GET_CREDIT_HISTORY_MEMBER)
    ResponseEntity<InformationResponse> getInformationPeople
            (@PathVariable String personIdentification);

    @PostMapping(IInformationPeopleEndPoint.SAVE_INFORMATION_MEMBER)
    ResponseEntity<InformationResponse> saveInformationPeople
            (@RequestBody InformationPeopleDocument informationPeopleDocument);
}