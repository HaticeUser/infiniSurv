package com.mighty.infinitysurveyposts.models.survey;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tpost", schema = "dbsurvey")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id ;
    private Date created_At = new Date();
    private String question;
    @Column(name = "object_id")
    private int object_ID;
   // @OneToMany(mappedBy = "tpost", cascade = CascadeType.ALL)
    //private List<OpinionModel> opinions;
    private int likes;
    @Column(name = "user_storings")
    private int savings;
    private boolean likes_disabled;
    private boolean user_storings_disabled;

    public PostModel(Date created_at, String question, Integer likes, Integer savings, boolean likes_disabled, boolean user_storings_disabled) {
        this.created_At = created_at;
        this.question = question;
        this.likes = likes;
        this.savings = savings;
        this.likes_disabled = likes_disabled;
        this.user_storings_disabled = user_storings_disabled;

    }

    public PostModel() {

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

    public int getObject_ID() {
        return object_ID;
    }

    public void setObject_ID(int object_ID) {
        this.object_ID = object_ID;
    }
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
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
