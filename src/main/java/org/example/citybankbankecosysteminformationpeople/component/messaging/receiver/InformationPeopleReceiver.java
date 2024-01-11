package org.example.citybankbankecosysteminformationpeople.component.messaging.receiver;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationpeople.builder.exception.InformationPeopleGeneralException;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationpeople.common.constant.message.IInformationPeopleMessage;
import org.example.citybankbankecosysteminformationpeople.component.messaging.sender.InformationPeopleSender;
import org.example.citybankbankecosysteminformationpeople.service.implement.InformationPeopleService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InformationPeopleReceiver
{
    private final InformationPeopleService informationPeopleService;
    private final InformationPeopleSender informationPeopleSender;

    @RabbitListener(queues = {"${sacavix.queue.receiver}"})
    public void receive(InformationResponse message)
    {
        processMessage(message);
    }

    private void processMessage(InformationResponse message)
    {
        try {
            Thread.sleep(5000);

            ResponseEntity<InformationResponse> response =
                    this.informationPeopleService.getInformationPeople(message.message);

            InformationResponse responseBody = response.getBody();

            this.informationPeopleSender.send(responseBody);

        }catch (InterruptedException e){
            throw new InformationPeopleGeneralException(IInformationPeopleMessage.OPERATION_FAIL);
        }
    }
}