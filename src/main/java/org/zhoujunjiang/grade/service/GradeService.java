package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.dto.CourseScoreDistributionDTO;
import org.zhoujunjiang.grade.entity.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> findAll();
    Grade findById(int id);
    void saveOrUpdate(Grade grade);
    void delete(int id);
    List<CourseScoreDistributionDTO> getCourseScoreDistributions();
}
