package com.example.javaprojectfxml;

import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String to;
   // private String text;
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Message() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

//    public String getText() {
//        return ;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
}