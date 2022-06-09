package com.my.class_routine.repository;
import com.my.class_routine.model.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
    List<StudentDetails> findByActive(boolean active);
}

