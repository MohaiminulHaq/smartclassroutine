package com.my.class_routine.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetails extends BaseEntity {


    @Column(name = "Name", unique = true)
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NO_CLASS")
    private Integer noClass;


}
