package org.zhoujunjiang.grade.entity;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String courseNo;
    private String teacherId;
    private String semester;
    private String department;
    private String name;
    private String description;
    private Integer credit;
    private Integer hours;
}
