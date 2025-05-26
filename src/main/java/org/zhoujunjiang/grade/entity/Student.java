package org.zhoujunjiang.grade.entity;
import lombok.Data;
@Data
public class Student {
    private Integer id;
    private String studentNo;
    private String name;
    private String gender;
    private String className;
    private String email;
}