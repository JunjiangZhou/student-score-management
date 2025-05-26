package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Student;
import java.util.List;

public interface StudentService {

    // 添加学生
    boolean add(Student student);

    // 修改学生信息
    boolean update(Student student);

    // 删除学生
    boolean delete(Integer id);

    // 分页查询学生
    List<Student> findByPage(int page, int size);

    // 通过学号查询是否存在（注册校验用）
    Student findByStudentNo(String studentNo);
}
