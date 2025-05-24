package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.entity.Enrollment;
import java.util.List;

public interface EnrollmentMapper {
    int insert(Enrollment enrollment);
    int updateById(Enrollment enrollment);
    int deleteById(Integer id);
    List<Enrollment> selectAll();
    Enrollment selectById(Integer id);
}