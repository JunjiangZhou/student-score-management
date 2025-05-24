package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Course;
import org.zhoujunjiang.grade.mapper.CourseMapper;
import org.zhoujunjiang.grade.service.CourseService;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public boolean addCourse(Course course) {
        return courseMapper.insert(course) > 0;
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseMapper.updateById(course) > 0;
    }

    @Override
    public boolean deleteCourse(Integer id) {
        return courseMapper.deleteById(id) > 0;
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.selectAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.selectById(id);
    }
}