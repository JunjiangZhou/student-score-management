package org.zhoujunjiang.grade.entity;
import  lombok.Data;
@Data
public class Score {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Double score;
    private String semester;
}
