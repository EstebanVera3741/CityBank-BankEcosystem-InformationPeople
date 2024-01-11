package org.example.citybankbankecosysteminformationpeople.builder.exception.advice;

import org.example.citybankbankecosysteminformationpeople.builder.exception.InformationPeopleGeneralException;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.constant.message.IInformationPeopleMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InformationPeopleControllerException
{
    @ExceptionHandler(InformationPeopleGeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<InformationResponse> informationPeopleException
            (
                    InformationPeopleGeneralException informationPeopleGeneralException
            )
    {
        return ResponseEntity.badRequest().body(InformationResponse.builder()
                .message(informationPeopleGeneralException.getMessage())
                .objectResponse(IInformationPeopleMessage.INTERNAL_SERVER)
                .objectId(null)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}