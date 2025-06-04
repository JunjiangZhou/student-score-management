package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.entity.Student;
import java.util.List;

public interface StudentMapper {
    List<Student> findAll();
    Student findById(Long id);
    void insert(Student student);
    void update(Student student);
    void delete(Long id);
}
