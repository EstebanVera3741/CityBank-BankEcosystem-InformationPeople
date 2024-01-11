package org.example.citybankbankecosysteminformationpeople.repository;

import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IInformationPeopleRepository extends MongoRepository<InformationPeopleDocument, String>
{
    Optional<InformationPeopleDocument> findAllByPerson_Identification(String personIdentification);
}