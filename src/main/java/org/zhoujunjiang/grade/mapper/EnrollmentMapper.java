package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Param;
import org.zhoujunjiang.grade.entity.Enrollment;
import org.zhoujunjiang.grade.vo.CourseEnrollmentSummaryVO;
import org.zhoujunjiang.grade.vo.EnrollmentDetailVO;

import java.util.List;

public interface EnrollmentMapper {

    void save(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    boolean exists(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    List<CourseEnrollmentSummaryVO> findAllCoursesWithEnrollment();

    List<EnrollmentDetailVO> findStudentsByCourseId(@Param("courseId") Integer courseId);

    List<Enrollment> findAll();
}
