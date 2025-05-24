package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.Score;
import java.util.List;

public interface ScoreService {
    boolean addScore(Score score);
    boolean updateScore(Score score);
    boolean deleteScore(Integer id);
    List<Score> findAll();
    Score findById(Integer id);
}