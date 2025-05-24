package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.Score;
import org.zhoujunjiang.grade.service.ScoreService;
import org.zhoujunjiang.grade.util.Result;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add")
    public Result<Score> add(@RequestBody Score score) {
        return scoreService.addScore(score) ? Result.success("添加成功", score) : Result.error("添加失败");
    }

    @PutMapping("/update")
    public Result<Score> update(@RequestBody Score score) {
        return scoreService.updateScore(score) ? Result.success("修改成功", score) : Result.error("修改失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        return scoreService.deleteScore(id) ? Result.success("删除成功") : Result.error("删除失败");
    }

    @GetMapping("/list")
    public Result<List<Score>> list() {
        return Result.success("查询成功", scoreService.findAll());
    }

    @GetMapping("/get/{id}")
    public Result<Score> getById(@PathVariable Integer id) {
        Score score = scoreService.findById(id);
        return score != null ? Result.success("查询成功", score) : Result.error("未找到");
    }
}