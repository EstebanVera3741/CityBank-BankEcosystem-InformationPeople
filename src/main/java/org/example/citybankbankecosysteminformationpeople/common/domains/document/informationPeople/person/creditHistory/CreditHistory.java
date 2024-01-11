package org.example.citybankbankecosysteminformationpeople.common.domains.document.person.creditHistory;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreditHistory implements Serializable
{
    private double creditScore;
    private String history;
}