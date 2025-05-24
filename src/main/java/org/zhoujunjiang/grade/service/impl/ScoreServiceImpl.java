package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.Score;
import org.zhoujunjiang.grade.mapper.ScoreMapper;
import org.zhoujunjiang.grade.service.ScoreService;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public boolean addScore(Score score) {
        return scoreMapper.insert(score) > 0;
    }

    @Override
    public boolean updateScore(Score score) {
        return scoreMapper.updateById(score) > 0;
    }

    @Override
    public boolean deleteScore(Integer id) {
        return scoreMapper.deleteById(id) > 0;
    }

    @Override
    public List<Score> findAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public Score findById(Integer id) {
        return scoreMapper.selectById(id);
    }
}