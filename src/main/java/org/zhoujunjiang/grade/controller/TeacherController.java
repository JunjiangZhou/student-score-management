package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.Teacher;
import org.zhoujunjiang.grade.service.TeacherService;
import org.zhoujunjiang.grade.util.Result;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public Result add(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher) ? Result.success("添加成功") : Result.error("添加失败");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher) ? Result.success("修改成功") : Result.error("修改失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return teacherService.deleteTeacher(id) ? Result.success("删除成功") : Result.error("删除失败");
    }

    @GetMapping("/list")
    public Result<List<Teacher>> list() {
        return Result.success("查询成功", teacherService.findAll());
    }

    @GetMapping("/get/{id}")
    public Result<Teacher> getById(@PathVariable Integer id) {
        Teacher teacher = teacherService.findById(id);
        return teacher != null ? Result.success("查询成功", teacher) : Result.<Teacher>error("未找到");
    }
}
