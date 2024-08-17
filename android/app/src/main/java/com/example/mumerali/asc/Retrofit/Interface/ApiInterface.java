package com.example.mumerali.asc.Retrofit.Interface;

import com.example.mumerali.asc.Retrofit.Models.CoursesOffered;
import com.example.mumerali.asc.Retrofit.Models.Files;
import com.example.mumerali.asc.Retrofit.Models.Profiles;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("fileInfo.php")
    Call<List<Files>> getFilesInfo(
            @Query("course_type")String course_type,
            @Query("course")String course,
            @Query("semester")String semester);

    @GET("facultyInfo.php")
    Call<List<Profiles>> getFacultyInfo(
            @Query("department")String department);

    @GET("courseinfo.php")
    Call<List<CoursesOffered>> getCourseInfo(
            @Query("course_type")String course_Type);


}
