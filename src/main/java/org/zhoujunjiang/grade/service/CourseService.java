package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    void delete(Long id);
}

