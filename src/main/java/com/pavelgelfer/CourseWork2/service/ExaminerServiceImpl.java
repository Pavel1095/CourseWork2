package com.pavelgelfer.CourseWork2.service;

import com.pavelgelfer.CourseWork2.dto.Question;
import com.pavelgelfer.CourseWork2.exception.NotEnoughException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random rnd = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughException();
        }

        Set<Question> resultQuestionSet = new HashSet<>();
        while (resultQuestionSet.size() < amount) {
            resultQuestionSet.add(questionService.getRandomQuestion());
        }
        return resultQuestionSet;
    }
}
