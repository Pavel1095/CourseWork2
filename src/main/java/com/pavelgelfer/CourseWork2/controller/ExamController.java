package com.pavelgelfer.CourseWork2.controller;

import com.pavelgelfer.CourseWork2.dto.Question;
import com.pavelgelfer.CourseWork2.service.ExaminerService;
import com.pavelgelfer.CourseWork2.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
