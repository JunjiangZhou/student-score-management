package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.dto.CourseScoreDistributionDTO;
import org.zhoujunjiang.grade.entity.Grade;

import java.util.List;

public interface GradeMapper {
    List<Grade> findAll();
    Grade findById(int id);
    void insert(Grade grade);
    void update(Grade grade);
    void delete(int id);

    List<CourseScoreDistributionDTO> getCourseScoreDistributions();
}
