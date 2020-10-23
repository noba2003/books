package com.example.books.recycileview;


import java.io.Serializable;

public class item implements Serializable {
    int idRamdam;
        private int imgLesson, dateLesson;
        private String lessonTiltle, author;
        private float RatingBar;

    public item() {
    }

    public item( int imgLesson, int dateLesson, String lessonTiltle, String author, float ratingBar) {
        this.idRamdam =(int) Math.random()*100000;
        this.imgLesson = imgLesson;
        this.dateLesson = dateLesson;
        this.lessonTiltle = lessonTiltle;
        this.author = author;
        RatingBar = ratingBar;
    }

    public int getImgLesson() {
        return imgLesson;
    }

    public void setImgLesson(int imgLesson) {
        this.imgLesson = imgLesson;
    }

    public int getDateLesson() {
        return dateLesson;
    }

    public void setDateLesson(int dateLesson) {
        this.dateLesson = dateLesson;
    }

    public String getLessonTiltle() {
        return lessonTiltle;
    }

    public void setLessonTiltle(String lessonTiltle) {
        this.lessonTiltle = lessonTiltle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getRatingBar() {
        return RatingBar;
    }

    public void setRatingBar(float ratingBar) {
        RatingBar = ratingBar;
    }
}


