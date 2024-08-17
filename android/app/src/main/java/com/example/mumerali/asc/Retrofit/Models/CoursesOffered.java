package com.example.mumerali.asc.Retrofit.Models;

import com.google.gson.annotations.SerializedName;

public class CoursesOffered {

    @SerializedName("course")
    private String Programme;

    @SerializedName("Eligibility_Criteria")
    private String Eligibility_Criteria;


    public String getProgramme() {
        return Programme;
    }

    public String getEligibility_Criteria() {
        return Eligibility_Criteria;
    }
}
