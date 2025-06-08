package org.zhoujunjiang.grade.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Teacher {
    private Integer id;
    private String name;
    private String teacherNo;
    private String department;
    private Integer age;
    private String gender;
    private String title;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hire_Date;
}
