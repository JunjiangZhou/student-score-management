package org.zhoujunjiang.grade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseMapper.findById(id);
    }

    @Override
    public void save(Course course) {
        if (course.getId() == null) {
            courseMapper.insert(course);
        } else {
            courseMapper.update(course);
        }
    }

    @Override
    public void delete(Long id) {
        courseMapper.delete(id);
    }
}
