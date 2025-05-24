package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Enrollment;
import org.zhoujunjiang.grade.mapper.EnrollmentMapper;
import org.zhoujunjiang.grade.service.EnrollmentService;
import javax.annotation.Resource;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Resource
    private EnrollmentMapper enrollmentMapper;

    @Override
    public boolean addEnrollment(Enrollment enrollment) {
        return enrollmentMapper.insert(enrollment) > 0;
    }

    @Override
    public boolean updateEnrollment(Enrollment enrollment) {
        return enrollmentMapper.updateById(enrollment) > 0;
    }

    @Override
    public boolean deleteEnrollment(Integer id) {
        return enrollmentMapper.deleteById(id) > 0;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentMapper.selectAll();
    }

    @Override
    public Enrollment findById(Integer id) {
        return enrollmentMapper.selectById(id);
    }
}