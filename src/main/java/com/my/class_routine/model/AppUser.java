package com.my.class_routine.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.logging.Logger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SYA_APP_USER")
public class AppUser extends BaseEntity{


    private static final long serialVersionUID = 1L;

//    @SuppressWarnings("unused")
//    private static final Logger LOG = LoggerFactory.getLogger(AppUser.class);

    @Column(name = "USERNAME", length=50, nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", length=100)
    private String email;

    @Column(name = "MOBILE", length=20)
    private String mobile;

    @Column(name = "EMPLOYEE_CODE", length=50)
    private String employeeCode;

    @Column(name = "NAME", length=100)
    private String name;

    @Column(name = "BANGLA_NAME", length=100)
    private String banglaName;

    @Column(name = "DESIGNATION", length=100)
    private String designation;

    @Column(name = "IS_ACCOUNT_EXPIRED", columnDefinition = "boolean default false")
    private Boolean accountExpired = false;

    @Column(name = "IS_CREDENTIALS_EXPIRED", columnDefinition = "boolean default false")
    private Boolean credentialsExpired = false;

    @Column(name = "IS_ACCOUNT_LOCKED", columnDefinition = "boolean default false")
    private Boolean accountLocked = false;

//    @OneToOne
//    @JoinColumn(name = "PASSWORD_POLICY_ID", nullable = false)
//    private PasswordPolicy passwordPolicy;
//
//    @OneToOne
//    @JoinColumn(name = "OFFICE_ID")
//    private CommonLookupDetails office;
//
//    @OneToOne
//    @JoinColumn(name = "BILLING_OFFICE_ID")
//    private CommonLookupDetails billingOffice;
}
