package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    private String zipcode;
    private String city;
    private String addressBasic;
    private String addressDetail;

    public Address(String zipcode, String city, String addressBasic, String addressDetail) {
        this.zipcode = zipcode;
        this.city = city;
        this.addressBasic = addressBasic;
        this.addressDetail = addressDetail;
    }
}
