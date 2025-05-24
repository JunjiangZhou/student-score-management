package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Course;
import java.util.List;

public interface CourseService {
    boolean addCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourse(Integer id);
    List<Course> findAll();
    Course findById(Integer id);
}