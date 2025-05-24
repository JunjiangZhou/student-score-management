package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.Course;
import org.zhoujunjiang.grade.service.CourseService;
import org.zhoujunjiang.grade.util.Result;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Result<Course> add(@RequestBody Course course) {
        return courseService.addCourse(course) ? Result.success("添加成功") : Result.error("添加失败");
    }

    @PutMapping("/update")
    public Result<Course> update(@RequestBody Course course) {
        return courseService.updateCourse(course) ? Result.success("修改成功") : Result.error("修改失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        return courseService.deleteCourse(id) ? Result.success("删除成功") : Result.error("删除失败");
    }

    @GetMapping("/list")
    public Result<List<Course>> list() {
        return Result.success("查询成功", courseService.findAll());
    }

    @GetMapping("/get/{id}")
    public Result<Course> getById(@PathVariable Integer id) {
        Course course = courseService.findById(id);
        return course != null ? Result.success("查询成功", course) : Result.error("未找到");
    }
}