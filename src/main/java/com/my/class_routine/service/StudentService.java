package com.my.class_routine.service;

import com.my.class_routine.model.StudentDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    /*CURD*/
    StudentDetails save(StudentDetails studentDetails);

    StudentDetails update(StudentDetails studentDetails);

    StudentDetails delete(StudentDetails studentDetails);

    List<StudentDetails> getAll();

    List<StudentDetails> getAllActive();

    Page<StudentDetails> getPageableList(int page, int size);


}
