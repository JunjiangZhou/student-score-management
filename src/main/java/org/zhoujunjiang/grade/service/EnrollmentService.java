package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Enrollment;
import java.util.List;

public interface EnrollmentService {
    boolean addEnrollment(Enrollment enrollment);
    boolean updateEnrollment(Enrollment enrollment);
    boolean deleteEnrollment(Integer id);
    List<Enrollment> findAll();
    Enrollment findById(Integer id);
}