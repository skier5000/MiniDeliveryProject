package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class UserMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_mst_seq")
    private Long seq ;

    private String userId;
    private String userPassword;
    private String userName;
    private String phoneNumber;
    private String email;
    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private UserRoleType userRoleType;

    @Embedded
    private Address address;

    @Embedded
    private CommonColumn commonColumn;


}
