package org.zhoujunjiang.grade.service.impl;


import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Teacher;
import org.zhoujunjiang.grade.mapper.TeacherMapper;
import org.zhoujunjiang.grade.service.TeacherService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

@Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherMapper.findById(id);
    }

    @Override
    public void save(Teacher teacher) {
        if (teacher.getId() == null) {
            teacherMapper.insert(teacher);
        } else {
            teacherMapper.update(teacher);
        }
    }

    @Override
    public void delete(Long id) {
        teacherMapper.delete(id);
    }
}