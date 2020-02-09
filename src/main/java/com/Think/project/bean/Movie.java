package com.Think.project.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Movie {


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    String Title;
    String Actors ;
    String Director;
    String Producer;
    String Music_composer;
    String Production_house;
    String Release_Date;
    String Duration;
    String Language;
    String Budget;
    String Box_Office_Collection;

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getMusic_composer() {
        return Music_composer;
    }

    public void setMusic_composer(String music_composer) {
        Music_composer = music_composer;
    }

    public String getProduction_house() {
        return Production_house;
    }

    public void setProduction_house(String production_house) {
        Production_house = production_house;
    }

    public String  getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(String  release_Date) {
        Release_Date = release_Date;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getBox_Office_Collection() {
        return Box_Office_Collection;
    }

    public void setBox_Office_Collection(String box_Office_Collection) {
        Box_Office_Collection = box_Office_Collection;
    }



}
