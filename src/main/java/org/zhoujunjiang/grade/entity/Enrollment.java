package org.zhoujunjiang.grade.entity;
import lombok.Data;
@Data
public class Enrollment {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private String semester;
}
