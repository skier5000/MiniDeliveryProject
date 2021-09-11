package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class UserMstDto {

    private Long seq ;

    private String userId;
    private String userName;
    private String phoneNumber;
    private String email;
    private LocalDate joinDate;

    private String userRoleType;

    private String zipcode;
    private String city;
    private String addressBasic;
    private String addressDetail;

}
