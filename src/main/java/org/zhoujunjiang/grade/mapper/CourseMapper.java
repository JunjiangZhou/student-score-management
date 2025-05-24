package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.entity.Course;
import java.util.List;

public interface CourseMapper {
    int insert(Course course);
    int updateById(Course course);
    int deleteById(Integer id);
    List<Course> selectAll();
    Course selectById(Integer id);
}