package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.service.CourseService;
import org.zhoujunjiang.grade.service.EnrollmentService;
import org.zhoujunjiang.grade.service.StudentService;
import org.zhoujunjiang.grade.vo.CourseEnrollmentSummaryVO;
import org.zhoujunjiang.grade.vo.EnrollmentDetailVO;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private StudentService  studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        List<CourseEnrollmentSummaryVO> courseList = enrollmentService.findAllCoursesWithEnrollment();
        model.addAttribute("courses", courseList);
        return "enrollments";  // enrollments.jsp
    }

    @GetMapping("/course/{courseId}")
    public String listStudentsByCourse(@PathVariable Integer courseId, Model model) {
        List<EnrollmentDetailVO> students = enrollmentService.findStudentsByCourseId(courseId);
        model.addAttribute("students", students);
        return "enrollment-detail"; // enrollment-detail.jsp
    }
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("courses", courseService.findAll());
        return "enrollment-form";
    }

    @PostMapping("/save")
    public String saveEnrollment(@RequestParam("studentId") Integer studentId,
                                 @RequestParam("courseId") Integer courseId,
                                 Model model) {
        // 可以考虑去重检查（避免重复选课）
        if (enrollmentService.exists(studentId, courseId)) {
            model.addAttribute("error", "该学生已选该课程");
            return "redirect:/enrollments/new";
        }

        enrollmentService.save(studentId, courseId);
        return "redirect:/enrollments";
    }

}
