package org.zhoujunjiang.grade.service.impl;
import org.zhoujunjiang.grade.entity.Student;
import org.zhoujunjiang.grade.mapper.StudentMapper;
import org.zhoujunjiang.grade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean register(Student student) {
        if (findByStudentNo(student.getStudentNo()) != null) {
            return false; // 学号已存在
        }
        return studentMapper.insert(student) > 0;
    }

    @Override
    public Student login(String studentNo, String password) {
        Student student = studentMapper.findByStudentNo(studentNo);
        if (student != null && password.equals(student.getPassword())) {
            return student;
        }
        return null;
    }

    @Override
    public boolean add(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.update(student) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public List<Student> findByPage(int page, int size) {
        int offset = (page - 1) * size;
        return studentMapper.findByPage(offset, size);
    }

    @Override
    public Student findByStudentNo(String studentNo) {
        return studentMapper.findByStudentNo(studentNo);
    }
}
