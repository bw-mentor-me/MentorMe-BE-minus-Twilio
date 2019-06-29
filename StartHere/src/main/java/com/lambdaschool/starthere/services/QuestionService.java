package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Question;

import java.util.List;

public interface QuestionService
{
    List<Question> findAll();

    Question findQuestionById(long id);

    List<Question> findByUserName(String username);

    void delete(long id);

    Question save(Question question);
}