package com.example.demo;

import java.util.List;

public class Petition {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String content;
    private List<Signature> signatures;

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Petition.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }
}