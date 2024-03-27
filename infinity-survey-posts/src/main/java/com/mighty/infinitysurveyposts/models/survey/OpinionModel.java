package com.mighty.infinitysurveyposts.models.survey;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "topinion" , schema = "dbsurvey")
public class OpinionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    //@SequenceGenerator(name ="my_entity_seq",sequenceName = "my_entity_seq", allocationSize = 1)
    private Integer opinion_id;

    @ManyToOne
    @JoinColumn(name = "post_id" , referencedColumnName = "post_id")
    private PostModel post;

    private String opinion;
    private int opinion_order_id;
    private int votes;
    private int object_id;


    private int opinionlength;






    public OpinionModel(){

    }

    public String getOpinion() {
        return opinion;
    }
    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    public int getOpinion_order_id() {
        return opinion_order_id;
    }

    public void setOpinion_order_id(int opinion_order_id) {
        this.opinion_order_id = opinion_order_id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }


    public int getOpinionlength() {
        return opinionlength;
    }

    public int setOpinionlength(int opinionlength) {
        this.opinionlength = opinionlength;
        return opinionlength;
    }






}
