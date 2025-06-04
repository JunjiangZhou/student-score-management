package org.zhoujunjiang.grade.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    private Integer id;
    private String name;
    private String teacherNo;
    private String gender;
    private String title;
    private String email;
    private Date hire_Date;
}
