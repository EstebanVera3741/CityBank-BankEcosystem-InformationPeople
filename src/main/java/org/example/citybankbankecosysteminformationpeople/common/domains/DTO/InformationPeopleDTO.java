package org.example.citybankbankecosysteminformationpeople.common.domains.DTO;

import lombok.*;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationBank.InformationBankDocument;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.person.Person;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InformationPeopleDTO implements Serializable
{
    private String id;
    private Person person;
    private InformationBankDocument informationBank;
}