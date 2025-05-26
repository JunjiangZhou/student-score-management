package org.zhoujunjiang.grade.controller;

import org.zhoujunjiang.grade.entity.Student;
import org.zhoujunjiang.grade.service.StudentService;
import org.zhoujunjiang.grade.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 分页查询学生
     */
    @GetMapping("/list")
    @ResponseBody
    public Result list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int size) {
        List<Student> students = studentService.findByPage(page, size);
        return Result.success("查询成功", students);
    }

    /**
     * 添加学生
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Student student) {
        boolean success = studentService.add(student);
        return success ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 更新学生
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Student student) {
        boolean success = studentService.update(student);
        return success ? Result.success("修改成功") : Result.error("修改失败");
    }

    /**
     * 删除学生
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam Integer id) {
        boolean success = studentService.delete(id);
        return success ? Result.success("删除成功") : Result.error("删除失败");
    }

    /**
     * 学生退出登录
     */
    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session) {
        session.invalidate();
        return Result.success("已退出登录");
    }
}
