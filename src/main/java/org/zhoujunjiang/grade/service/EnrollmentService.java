package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Enrollment;
import org.zhoujunjiang.grade.vo.CourseEnrollmentSummaryVO;
import org.zhoujunjiang.grade.vo.EnrollmentDetailVO;
import java.util.List;

public interface EnrollmentService {
    List<CourseEnrollmentSummaryVO> findAllCoursesWithEnrollment();
    List<EnrollmentDetailVO> findStudentsByCourseId(Integer courseId);
    void save(Integer studentId, Integer courseId);
    boolean exists(Integer studentId, Integer courseId);

    List<Enrollment> findAll();
}

