package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.dto.CourseScoreDistributionDTO;
import org.zhoujunjiang.grade.entity.Grade;
import org.zhoujunjiang.grade.mapper.GradeMapper;
import org.zhoujunjiang.grade.service.GradeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> findAll() {
        return gradeMapper.findAll();
    }

    @Override
    public Grade findById(int id) {
        return gradeMapper.findById(id);
    }

    @Override
    public void saveOrUpdate(Grade grade) {
        if (grade.getId() == null) {
            gradeMapper.insert(grade);
        } else {
            gradeMapper.update(grade);
        }
    }

    @Override
    public void delete(int id) {
        gradeMapper.delete(id);
    }
    @Override
    public List<CourseScoreDistributionDTO> getCourseScoreDistributions() {
        return gradeMapper.getCourseScoreDistributions();
    }

}
