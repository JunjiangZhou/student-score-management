package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void delete(Long id);
}
