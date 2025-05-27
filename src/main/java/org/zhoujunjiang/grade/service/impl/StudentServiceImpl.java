package org.zhoujunjiang.grade.service.impl;
import org.zhoujunjiang.grade.entity.Student;
import org.zhoujunjiang.grade.mapper.StudentMapper;
import org.zhoujunjiang.grade.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentMapper studentMapper;



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
