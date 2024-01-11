package org.example.citybankbankecosysteminformationpeople.common.constant.endPoint;

public interface IInformationPeopleEndPoint
{
    String BASE_URL = "microserviceInformation-people";
    String GET_CREDIT_HISTORY_MEMBER = "/get/{personIdentification}";
    String SAVE_INFORMATION_MEMBER = "/save-InformationMember";
}