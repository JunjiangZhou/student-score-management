package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Teacher;
import org.zhoujunjiang.grade.mapper.TeacherMapper;
import org.zhoujunjiang.grade.service.TeacherService;
import java.util.List;
import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher) > 0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateById(teacher) > 0;
    }

    @Override
    public boolean deleteTeacher(Integer id) {
        return teacherMapper.deleteById(id) > 0;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherMapper.selectById(id);
    }
}