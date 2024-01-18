package com.pavelgelfer.CourseWork2.service;

import com.pavelgelfer.CourseWork2.dto.Question;
import com.pavelgelfer.CourseWork2.exception.NotEnoughException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    @Test
    void getQuestion_shouldThrowExceptionWhenNotEnoughQuestions() {
        when(questionService.getAll()).
                thenReturn(Collections.emptySet());
        assertThrows(NotEnoughException.class,
                () -> underTest.getQuestions(1));
    }

    @Test
    void getQuestion_shouldReturnUniqueQuestionCollection() {
        int amount = 2;
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Set<Question> testSet = Set.of(question1, question2);
        when(questionService.getAll()).
                thenReturn(testSet);
        when(questionService.getRandomQuestion()).
                thenReturn(question1, question2);
        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(testSet, result);
        assertEquals(amount, result.stream().distinct().count());
    }
}