package com.example.mumerali.asc.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Client.ApiClient;
import com.example.mumerali.asc.Retrofit.Interface.ApiInterface;
import com.example.mumerali.asc.Retrofit.Models.CoursesOffered;
import com.example.mumerali.asc.Recyclers.CourseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<CoursesOffered> coursesOffered;
    private CourseAdapter adapter;
    private ApiInterface apiInterface;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        layoutManager =  new LinearLayoutManager(this);
        recyclerView= (RecyclerView)findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String CourseType = intent.getStringExtra("Course Type");
        fetchInformation(CourseType);

    }
    public void fetchInformation(String CourseType)
    {
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<CoursesOffered>> call = apiInterface.getCourseInfo(CourseType);
        call.enqueue(new Callback<List<CoursesOffered>>() {
            @Override
            public void onResponse(Call<List<CoursesOffered>> call, Response<List<CoursesOffered>> response) {

                coursesOffered = response.body();
                adapter= new CourseAdapter(coursesOffered,context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CoursesOffered>> call, Throwable t) {

            }
        });
    }
}



