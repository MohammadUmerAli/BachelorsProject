package com.example.mumerali.asc.Activities;


import android.content.Intent;
import android.os.Bundle;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Client.ApiClient;
import com.example.mumerali.asc.Retrofit.Interface.ApiInterface;
import com.example.mumerali.asc.Retrofit.Models.Files;
import com.example.mumerali.asc.Recyclers.SyllabusAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SyllabusActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Files> files;
    private SyllabusAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        recyclerView= (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String courseType = intent.getStringExtra("courseType");
        String course = intent.getStringExtra("course");
        String semester = intent.getStringExtra("semester");
        fetchInformation(courseType, course, semester);

    }

    public void fetchInformation(String Course_Type , String Course, String Semester)
    {
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Files>> call = apiInterface.getFilesInfo(Course_Type,Course,Semester);
        call.enqueue(new Callback<List<Files>>() {
            @Override
            public void onResponse(Call<List<Files>> call, Response<List<Files>> response) {

                files = response.body();
                adapter= new SyllabusAdapter(files, getBaseContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Files>> call, Throwable t) {

            }
        });
    }
}
