package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private String zipcode; // 우편번호
    private String city; // 시 구분
    private String addressBasic; // 도 시 구 구분
    private String addressDetail; // 디테일 주소

    public AddressDto(String zipcode, String city, String addressBasic, String addressDetail) {
        this.zipcode = zipcode;
        this.city = city;
        this.addressBasic = addressBasic;
        this.addressDetail = addressDetail;
    }

}
