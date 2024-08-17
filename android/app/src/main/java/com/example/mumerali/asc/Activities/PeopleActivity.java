package com.example.mumerali.asc.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Client.ApiClient;
import com.example.mumerali.asc.Retrofit.Interface.ApiInterface;
import com.example.mumerali.asc.Retrofit.Models.Profiles;
import com.example.mumerali.asc.Recyclers.PeopleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Profiles> profiles;
    private PeopleAdapter adapter;
    private ApiInterface apiInterface;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        layoutManager =  new LinearLayoutManager(this);
        recyclerView= (RecyclerView)findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();

        String department = intent.getStringExtra("department");


        fetchInformation(department);

    }
    public void fetchInformation(String department)
    {
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Profiles>> call = apiInterface.getFacultyInfo(department);
        call.enqueue(new Callback<List<Profiles>>() {
            @Override
            public void onResponse(Call<List<Profiles>> call, Response<List<Profiles>> response) {

                profiles = response.body();
                adapter= new PeopleAdapter(profiles,context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Profiles>> call, Throwable t) {

            }
        });
    }
}
