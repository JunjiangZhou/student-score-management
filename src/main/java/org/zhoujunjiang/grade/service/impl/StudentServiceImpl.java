package org.zhoujunjiang.grade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Student;
import org.zhoujunjiang.grade.mapper.StudentMapper;
import org.zhoujunjiang.grade.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            studentMapper.insert(student);
        } else {
            studentMapper.update(student);
        }
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
