package com.my.class_routine.service;
import com.my.class_routine.model.StudentDetails;
import com.my.class_routine.repository.StudentDetailsRepository;
import com.my.class_routine.util.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private StudentDetailsRepository repo;

    private final CommonUtils commonUtils;

    @Override
    public StudentDetails save(StudentDetails entity) {
        commonUtils.setEntryUserInfo(entity);
        return repo.save(entity);
    }

    @Override
    public StudentDetails update(StudentDetails entity) {
        StudentDetails dbEntity = repo.findById(entity.getId()).get();
        commonUtils.setUpdateUserInfo(entity, dbEntity);
        return repo.save(entity);
    }

    @Override
    public StudentDetails delete(StudentDetails entity) {
        repo.delete(entity);
        return entity;
    }

    @Override
    public List<StudentDetails> getAll() {
        return repo.findAll();
    }

    @Override
    public List<StudentDetails> getAllActive() {
        return repo.findByActive(true);
    }

    @Override
    public Page<StudentDetails> getPageableList(int page, int size) {
        PageRequest pageRequest = commonUtils.getPageRequest(page, size);
        Page<StudentDetails> pageResult = repo.findAll(pageRequest);
        List<StudentDetails> objList = pageResult.stream()
                .collect(Collectors.toList());
        return new PageImpl<>(objList, pageRequest, pageResult.getTotalElements());
    }


}
