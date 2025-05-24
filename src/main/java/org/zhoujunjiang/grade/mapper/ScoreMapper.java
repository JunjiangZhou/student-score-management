package org.zhoujunjiang.grade.mapper;

import org.zhoujunjiang.grade.entity.Score;
import java.util.List;

public interface ScoreMapper {
    int insert(Score score);
    int updateById(Score score);
    int deleteById(Integer id);
    List<Score> selectAll();
    Score selectById(Integer id);
}