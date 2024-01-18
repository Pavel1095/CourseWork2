package com.pavelgelfer.CourseWork2.service;

import com.pavelgelfer.CourseWork2.dto.Question;
import com.pavelgelfer.CourseWork2.exception.NotEnoughException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private  Question question = new Question("question", "answer");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());

        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void remove_shouldDeleteQuestionFromSetAndReturnQuestion() {
        Question result = underTest.remove(question);

        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void getAll_shouldReturnQuestionCollection() {
        Question testQuestion2 = new Question("testQuestion2", "testAnswer2");
        underTest.add(question);
        underTest.add(testQuestion2);
        Collection<Question> result = underTest.getAll();

        assertEquals(Set.of(question, testQuestion2), result);
    }

    @Test
    void getRandomQuestion_shouldThrowExceptionWhenSetIsEmpty() {

        assertThrows(NotEnoughException.class,
                () -> underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnQuestionWhenSetIsNotEmpty() {
        underTest.add(question);
        Question result = underTest.getRandomQuestion();
        assertEquals(question, result);

    }
}