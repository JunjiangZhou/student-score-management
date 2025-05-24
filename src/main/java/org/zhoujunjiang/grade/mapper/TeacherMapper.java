package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.entity.Teacher;
import java.util.List;

public interface TeacherMapper {
    int insert(Teacher teacher);
    int updateById(Teacher teacher);
    int deleteById(Integer id);
    List<Teacher> selectAll();
    Teacher selectById(Integer id);
}