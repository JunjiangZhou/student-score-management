package org.zhoujunjiang.grade.entity;
import lombok.Data;
@Data
public class Course {
    private Integer id;
    private String courseNo;
    private String courseName;
    private Integer credit;
    private Integer hours;
    private String classroom;
    private Integer teacherId;
}
