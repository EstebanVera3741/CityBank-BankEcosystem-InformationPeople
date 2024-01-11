package org.example.citybankbankecosysteminformationpeople.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationpeople.builder.exception.InformationPeopleGeneralException;
import org.example.citybankbankecosysteminformationpeople.builder.response.InformationPeopleBuildReturn;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.constant.message.IInformationPeopleMessage;
import org.example.citybankbankecosysteminformationpeople.common.converter.InformationPeopleMapper;
import org.example.citybankbankecosysteminformationpeople.common.domains.DTO.InformationPeopleDTO;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.example.citybankbankecosysteminformationpeople.repository.IInformationPeopleRepository;
import org.example.citybankbankecosysteminformationpeople.service.IInformationPeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InformationPeopleService implements IInformationPeopleService
{
    private final IInformationPeopleRepository iInformationPeopleRepository;

    @Override
    public ResponseEntity<InformationResponse> getInformationPeople
            (
                    String personIdentification
            )
    {
        try {
            Optional<InformationPeopleDocument> informationPeopleDocumentExist =
                    this.iInformationPeopleRepository.findAllByPerson_Identification(personIdentification);
            if (informationPeopleDocumentExist.isEmpty())
            {
                return InformationPeopleBuildReturn.buildReturnFailed
                        (
                                IInformationPeopleMessage.OPERATION_FAIL,
                                IInformationPeopleMessage.READ_FAIL,
                                null
                        );
            }
            InformationPeopleDTO informationPeopleDTO =
                    InformationPeopleMapper.INSTANCE.DocumentToDTO(informationPeopleDocumentExist.get());

            return InformationPeopleBuildReturn.buildReturnSuccess
                    (
                            IInformationPeopleMessage.OPERATION_SUCCESS,
                            informationPeopleDTO,
                            null
                    );
        }catch (Exception e){
            throw new InformationPeopleGeneralException(IInformationPeopleMessage.OPERATION_FAIL);
        }
    }

    @Override
    public ResponseEntity<InformationResponse> saveInformationPeople
            (
                    InformationPeopleDocument informationPeopleDocument
            )
    {
        try {
            String personIdentification = informationPeopleDocument.getPerson().getIdentification();
            Optional<InformationPeopleDocument> informationPeopleDocumentExist =
                    this.iInformationPeopleRepository.findAllByPerson_Identification(personIdentification);
            if (informationPeopleDocumentExist.isPresent())
            {
                return InformationPeopleBuildReturn.buildReturnFailed
                        (
                                IInformationPeopleMessage.OPERATION_FAIL,
                                IInformationPeopleMessage.CREATE_FAIL,
                                null
                        );
            }

            this.iInformationPeopleRepository.save(informationPeopleDocument);

            return InformationPeopleBuildReturn.buildReturnSuccess
                    (
                            IInformationPeopleMessage.OPERATION_SUCCESS,
                            IInformationPeopleMessage.CREATE_SUCCESS,
                            null
                    );
        }catch (Exception e){
            throw new InformationPeopleGeneralException(IInformationPeopleMessage.OPERATION_FAIL);
        }
    }
}