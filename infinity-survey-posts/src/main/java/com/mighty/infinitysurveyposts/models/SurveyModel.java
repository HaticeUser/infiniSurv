package com.mighty.infinitysurveyposts.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tpost", schema = "dbsurvey")
public class SurveyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id ;
    private Date created_At = new Date();
    private String question;
    private Integer likes;
    private Integer user_storings;
    private boolean likes_disabled;
    private boolean user_storings_disabled;

    protected void SurveyModel(Date created_at, String question, Integer likes,Integer user_storings,boolean likes_disabled, boolean user_storings_disabled) {
        this.created_At = created_at;
        this.question = question;
        this.likes = likes;
        this.user_storings = user_storings;
        this.likes_disabled = likes_disabled;
        this.user_storings_disabled = user_storings_disabled;

    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    public Integer getUser_storings() {
        return user_storings;
    }

    public void setUser_storings(Integer user_storings) {
        this.user_storings = user_storings;
    }

    public boolean getLikes_disabled() {
        return likes_disabled;
    }

    public void setLikes_disabled(boolean likes_disabled) {
        this.likes_disabled = likes_disabled;
    }

    public boolean getUser_storings_disabled() {
        return user_storings_disabled;
    }

    public void setUser_storings_disabled(boolean user_storings_disabled) {
        this.user_storings_disabled = user_storings_disabled;
    }


}
