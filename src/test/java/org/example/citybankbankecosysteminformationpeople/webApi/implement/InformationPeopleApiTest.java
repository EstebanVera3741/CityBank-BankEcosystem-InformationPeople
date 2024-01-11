package org.example.citybankbankecosysteminformationpeople.webApi.implement;

import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.person.creditHistory.CreditHistory;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.person.employment.Employment;
import org.example.citybankbankecosysteminformationpeople.common.constant.message.IInformationPeopleMessage;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.person.address.Address;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.person.contact.Contact;
import org.example.citybankbankecosysteminformationpeople.service.implement.InformationPeopleService;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.person.Person;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.time.LocalDate;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InformationPeopleApiTest {

    @Mock
    private InformationPeopleService informationPeopleService;
    private InformationPeopleApi informationPeopleApi;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this).close();
        informationPeopleApi = new InformationPeopleApi(informationPeopleService);
    }

    @Test
    void saveInformationPeopleSuccess() {
        InformationPeopleDocument request = new InformationPeopleDocument();
            Person person = new Person();
                person.setIdentification("1001001000");
                person.setFirstName("Diego Esteban");
                person.setLastName("Vera Enciso");
                LocalDate dateOfBirth = LocalDate.parse("1994-03-01");
                person.setDateOfBirth(dateOfBirth);
                person.setGender("Masculino");
            Address address = new Address();
                address.setNationality("Colombiano");
                address.setState("Tolima");
                address.setCity("Ibague");
                address.setStreet("Cra 3 #32-61 Barrio Brisas");
                address.setPostalCode("730006");
                person.setAddress(address);
            Contact contact = new Contact();
                contact.setPhoneNumber("+57 3103302209");
                contact.setEmailAddress("estebanvera@gmail.com");
                person.setContact(contact);
            Employment employment = new Employment();
                employment.setCompanyName("Globant");
                employment.setPosition("Developer");
                employment.setMonthlyIncome(1180000.00);
                person.setEmployment(employment);
            CreditHistory creditHistory = new CreditHistory();
                creditHistory.setCreditScore(98.8);
                creditHistory.setHistory("Bueno");
                person.setCreditHistory(creditHistory);
            request.setPerson(person);

        InformationResponse expectedResponse = new InformationResponse();
            expectedResponse.setMessage(IInformationPeopleMessage.OPERATION_SUCCESS);
            expectedResponse.setObjectResponse(IInformationPeopleMessage.CREATE_SUCCESS);
            expectedResponse.setStatusCode(HttpStatus.OK.value());

        when(informationPeopleService.saveInformationPeople(any()))
                .thenReturn(ResponseEntity.ok(expectedResponse));
        ResponseEntity<InformationResponse> response =
                this.informationPeopleApi.saveInformationPeople(request);

        assertEquals(IInformationPeopleMessage.OPERATION_SUCCESS,
                Objects.requireNonNull(response.getBody()).getMessage());
        assertEquals(IInformationPeopleMessage.CREATE_SUCCESS,
                Objects.requireNonNull(response.getBody()).getObjectResponse());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(informationPeopleService,
                times(1)).saveInformationPeople(request);
    }
}