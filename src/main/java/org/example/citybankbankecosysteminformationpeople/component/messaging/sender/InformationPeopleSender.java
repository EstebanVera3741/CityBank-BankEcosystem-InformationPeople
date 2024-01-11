package org.example.citybankbankecosysteminformationpeople.component.messaging.sender;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationpeople.builder.response.implement.InformationResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@RequiredArgsConstructor
public class InformationPeopleSender
{

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void send(InformationResponse message)
    {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}