package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.Enrollment;
import org.zhoujunjiang.grade.service.EnrollmentService;
import org.zhoujunjiang.grade.util.Result;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/add")
    public Result add(@RequestBody Enrollment enrollment) {
        boolean success = enrollmentService.addEnrollment(enrollment);
        return success ? Result.success("添加成功") : Result.error("添加失败");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Enrollment enrollment) {
        boolean success = enrollmentService.updateEnrollment(enrollment);
        return success ? Result.success("更新成功") : Result.error("更新失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean success = enrollmentService.deleteEnrollment(id);
        return success ? Result.success("删除成功") : Result.error("删除失败");
    }

    @GetMapping("/find/{id}")
    public Result findById(@PathVariable Integer id) {
        Enrollment enrollment = enrollmentService.findById(id);
        return enrollment != null ? Result.success("查询成功", enrollment) : Result.error("未找到记录");
    }

    @GetMapping("/list")
    public Result findAll() {
        List<Enrollment> list = enrollmentService.findAll();
        return Result.success("查询成功", list);
    }
}
