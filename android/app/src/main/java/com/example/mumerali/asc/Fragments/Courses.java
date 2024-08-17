package com.example.mumerali.asc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mumerali.asc.Activities.CourseActivity;
import com.example.mumerali.asc.R;

public class Courses extends Fragment {


    Spinner courseTypeSpin;
    String  courseType;
    String  type[] = {"Select Course Type","Integrated Courses", "Honor’s Courses", "Undergraduate Courses", "Postgraduate Courses"};


    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.courses, container, false);


        courseTypeSpin = (Spinner) view.findViewById(R.id.courseTypeSpin);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, type);
        courseTypeSpin.setAdapter(arrayAdapter);

        courseTypeSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    if (isOnline()) {
                        String Selected = adapterView.getItemAtPosition(i).toString();
                        courseType = Selected;

                        Intent intent = new Intent(getActivity(), CourseActivity.class);
                        intent.putExtra("Course Type", courseType);
                        startActivity(intent);

                    } else Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }


    public boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}

