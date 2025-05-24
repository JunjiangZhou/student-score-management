package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Param;
import org.zhoujunjiang.grade.entity.Student;

import java.util.List;

public interface StudentMapper {

    int insert(Student student);

    int update(Student student);

    int deleteById(@Param("id") Integer id);

    Student findByStudentNo(@Param("studentNo") String studentNo);

    List<Student> findByPage(@Param("offset") int offset, @Param("limit") int limit);
}
