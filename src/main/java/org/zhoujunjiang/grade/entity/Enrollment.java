package org.zhoujunjiang.grade.entity;

import lombok.Data;

@Data
public class Enrollment {
    private Integer id;           // 主键
    private Integer studentId;    // 外键：学生ID
    private Integer courseId;     // 外键：课程ID
}
