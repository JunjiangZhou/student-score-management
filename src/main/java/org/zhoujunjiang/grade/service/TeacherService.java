package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Teacher;
import java.util.List;

public interface TeacherService {
    boolean addTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(Integer id);
    List<Teacher> findAll();
    Teacher findById(Integer id);
}