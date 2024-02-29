package com.mighty.infinitysurveyposts.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "tpost", schema = "dbsurvey")
public class SurveyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer survey_id ;
    private String question;
   // private ArrayList<String> inputData = new ArrayList<String>(); // was stimmt hier nicht ? nachschauen.
    private Integer answers_Length;
    private Integer likes; //im frontend verbessern, wird im frontend übergeben
    private Integer user_storings; //im frontend verbessern, wird im frontend übergeben
    private Date created_at;
    private boolean likes_disabled; //im frontend verbessern, wird im frontend übergeben
    private boolean user_storings_disabled; //im frontend verbessern, wird im frontend übergeben
}
