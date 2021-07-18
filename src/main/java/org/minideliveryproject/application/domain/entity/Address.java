package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    private String zipcode; // 우편번호
    private String city; // 시 구분
    private String addressBasic; // 도 시 구 구분
    private String addressDetail; // 디테일 주소

    public Address(String zipcode, String city, String addressBasic, String addressDetail) {
        this.zipcode = zipcode;
        this.city = city;
        this.addressBasic = addressBasic;
        this.addressDetail = addressDetail;
    }
}
