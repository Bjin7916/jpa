package com.jpa.advanced.entity.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @ToString
public class MemberAddress {
    private String memberAddress;
    private String memberAddressDetail;
    private String memberZipcode;
}
