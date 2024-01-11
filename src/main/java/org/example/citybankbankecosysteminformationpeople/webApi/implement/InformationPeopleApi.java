package org.example.citybankbankecosysteminformationpeople.webApi.implement;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.constant.endPoint.IInformationPeopleEndPoint;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.example.citybankbankecosysteminformationpeople.service.implement.InformationPeopleService;
import org.example.citybankbankecosysteminformationpeople.webApi.IInformationPeopleApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IInformationPeopleEndPoint.BASE_URL)
@RequiredArgsConstructor
public class InformationPeopleApi implements IInformationPeopleApi
{
    private final InformationPeopleService informationPeopleService;

    @Override
    @GetMapping(IInformationPeopleEndPoint.GET_CREDIT_HISTORY_MEMBER)
    public ResponseEntity<InformationResponse> getInformationPeople
            (@PathVariable String personIdentification)
    {
        return this.informationPeopleService.getInformationPeople(personIdentification);
    }

    @Override
    @PostMapping(IInformationPeopleEndPoint.SAVE_INFORMATION_MEMBER)
    public ResponseEntity<InformationResponse> saveInformationPeople
            (@RequestBody InformationPeopleDocument informationPeopleDocument)
    {
        return this.informationPeopleService.saveInformationPeople(informationPeopleDocument);
    }
}