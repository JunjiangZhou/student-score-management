package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhoujunjiang.grade.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<Teacher> findAll();
    Teacher findById(Long id);
    void insert(Teacher teacher);
    void update(Teacher teacher);
    void delete(Long id);
}