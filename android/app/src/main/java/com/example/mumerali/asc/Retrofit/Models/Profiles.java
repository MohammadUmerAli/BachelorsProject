package com.example.mumerali.asc.Retrofit.Models;


import com.google.gson.annotations.SerializedName;

public class Profiles {

    @SerializedName("teacher name")
    private String teacher_name;

    @SerializedName("teacher qualification")
    private String teacher_qualification;

    @SerializedName("teacher email")
    private String teacher_email;

    @SerializedName("positionn held")
    private String position_held;

    @SerializedName("image url")
    private String image_url;



    public String getTeacher_name()
    {
        return teacher_name;

    }

    public String getTeacher_qualification()
    {
        return teacher_qualification;

    }

    public String getTeacher_email()
    {
        return teacher_email;

    }

    public String getPosition_held()
    {
        return position_held;

    }

    public String getImage_url()
    {
        return image_url;

    }

}

