package org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople;

import lombok.*;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationBank.InformationBankDocument;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.person.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "information_people")
public class InformationPeopleDocument
{
    @Id
    private String id;
    @Field
    private Person person;
    @Field
    private InformationBankDocument informationBank;
}