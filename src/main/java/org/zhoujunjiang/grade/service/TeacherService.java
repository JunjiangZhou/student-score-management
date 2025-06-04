package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(Long id);
    void save(Teacher teacher);
    void delete(Long id);
}
