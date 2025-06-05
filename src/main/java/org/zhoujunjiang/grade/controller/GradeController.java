package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhoujunjiang.grade.dto.CourseScoreDistributionDTO;
import org.zhoujunjiang.grade.entity.Grade;
import org.zhoujunjiang.grade.service.EnrollmentService;
import org.zhoujunjiang.grade.service.GradeService;

import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("gradeList", gradeService.findAll());
        return "grades";
    }

    @GetMapping("/new")
    public String toAdd(Model model) {
        model.addAttribute("grade", new Grade());
        model.addAttribute("enrollments", enrollmentService.findAll());
        return "grade-form";
    }

    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable int id, Model model) {
        model.addAttribute("grade", gradeService.findById(id));
        model.addAttribute("enrollments", enrollmentService.findAll());
        return "grade-form";
    }

    @PostMapping("/save")
    public String save(Grade grade) {
        gradeService.saveOrUpdate(grade);
        return "redirect:/grades";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        gradeService.delete(id);
        return "redirect:/grades";
    }
    @GetMapping("/statistics/score-distribution")
    public String showScoreDistribution(Model model) {
        List<CourseScoreDistributionDTO> list = gradeService.getCourseScoreDistributions();
        model.addAttribute("distributionList", list);
        return "score-distribution"; // JSP 页面
    }

}
