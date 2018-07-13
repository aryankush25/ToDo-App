package com.example.aryankush25.todoapp;

public class TodoItem {

    private String mtitle;
    private String msampleText;
    public int Id;

    public TodoItem(String title, String sampleText) {
        mtitle = title;
        msampleText = sampleText;
    }
    public TodoItem(){ }

    public String getMtitle() {
        return mtitle;
    }

    public String getMsampleText() {
        return msampleText;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
