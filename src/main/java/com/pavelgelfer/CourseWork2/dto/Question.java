package com.pavelgelfer.CourseWork2.dto;

import java.util.Objects;

public class Question {
    private String Question;
    private String Answer;

    public Question(String question, String answer) {
        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(Question, question.Question) && Objects.equals(Answer, question.Answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Question, Answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "Question='" + Question + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}
