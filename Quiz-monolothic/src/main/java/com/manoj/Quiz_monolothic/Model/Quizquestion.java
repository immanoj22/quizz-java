package com.manoj.Quiz_monolothic.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quizquestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesid;
    private String title;
    @ManyToMany
    private List<Quiz> Quizquestion;

    public int getId() {
        return quesid;
    }

    public void setId(int id) {
        this.quesid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Quiz> getQuizquestion() {
        return Quizquestion;
    }

    public void setQuizquestion(List<Quiz> quizquestion) {
        Quizquestion = quizquestion;
    }
}
