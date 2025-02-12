package com.manoj.Quiz_monolothic.Model;

public class Responsefromquiz {
    int id;
    String response;

    public Responsefromquiz() {
    }

    public Responsefromquiz(int id, String response) {
        this.id = id;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
