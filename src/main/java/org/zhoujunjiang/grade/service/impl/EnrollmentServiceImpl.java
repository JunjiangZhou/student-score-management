package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.mapper.EnrollmentMapper;
import org.zhoujunjiang.grade.service.EnrollmentService;
import org.zhoujunjiang.grade.vo.CourseEnrollmentSummaryVO;
import org.zhoujunjiang.grade.vo.EnrollmentDetailVO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Resource
    private EnrollmentMapper enrollmentMapper;

    @Override
    public void save(Integer studentId, Integer courseId) {
        enrollmentMapper.save(studentId, courseId);
    }

    @Override
    public boolean exists(Integer studentId, Integer courseId) {
        return enrollmentMapper.exists(studentId, courseId);
    }

    @Override
    public List<CourseEnrollmentSummaryVO> findAllCoursesWithEnrollment() {
        return enrollmentMapper.findAllCoursesWithEnrollment();
    }

    @Override
    public List<EnrollmentDetailVO> findStudentsByCourseId(Integer courseId) {
        return enrollmentMapper.findStudentsByCourseId(courseId);
    }
}
