package com.my.class_routine.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetails {


    @Column(name = "Name", unique = true)
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NO_CLASS")
    private Integer noClass;

    private static final long serialVersionUID = 9132875688068247271L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "ACTIVE", columnDefinition = "boolean default true")
    private Boolean active = true;

    @Column(name = "ENTRY_USER", updatable = false, nullable = false)
    private Integer entryUser;

    @Column(name = "ENTRY_DATE", updatable = false, nullable = false)
    private Date entryDate;

    @Column(name = "UPDATE_USER", insertable = false)
    private Integer updateUser;

    @Column(name = "UPDATE_DATE", insertable = false)
    private Date updateDate;

    @Column(name = "ENTRY_APP_USER_CODE", length=50)
    private String entryAppUserCode;

    @Column(name = "UPDATE_APP_USER_CODE", length=50)
    private String updateAppUserCode;

}
