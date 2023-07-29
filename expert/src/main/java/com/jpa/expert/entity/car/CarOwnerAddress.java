package com.jpa.expert.entity.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @ToString
public class CarOwnerAddress {
    private String carOwnerAddress;
    private String carOwnerAddressDetail;
    private String carOwnerZipcode;
}
