package com.achilles.achillesnote.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    private LocalDateTime createdOn;


    public Note() {
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        this.createdOn = LocalDateTime.now();
        createdOn.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss"));
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedOn() {
        return createdOn.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss"));
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
