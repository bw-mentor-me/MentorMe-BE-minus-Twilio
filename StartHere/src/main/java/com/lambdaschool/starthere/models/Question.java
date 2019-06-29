package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionsid;

    @Column(nullable = false)
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"questions", "hibernateLazyInitializer"})
    private User user;

    public Question()
    {
    }

    public Question(String question, User user)
    {
        this.question = question;
        this.user = user;
    }

    public long getQuestionsid()
    {
        return questionsid;
    }

    public void setQuestionsid(long questionsid)
    {
        this.questionsid = questionsid;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}