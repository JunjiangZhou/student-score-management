package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhoujunjiang.grade.entity.Course;
import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(Long id);
    void insert(Course course);
    void update(Course course);
    void delete(Long id);
}
