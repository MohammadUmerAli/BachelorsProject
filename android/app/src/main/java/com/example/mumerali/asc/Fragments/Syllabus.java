package com.example.mumerali.asc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.mumerali.asc.Activities.SyllabusActivity;
import com.example.mumerali.asc.R;

import static java.sql.Types.NULL;

public class Syllabus extends Fragment {

    Spinner courseTypeSpin, courseSpin, semesterSpin;
    String CourseType[] = {"Select Course Type","Honor’s Courses", "Integrated Courses", "Postgraduate Courses", "Undergraduate Courses"};
    String HonorCourses[] = {"Select Course","Commerce", "History"};
    String IntegratedCourses[] = {"Select Course","Economics", "English"};
    String PostgraduateCourses[] = {"Select Course","Arabic"};
    String UndergraduateCourses[] = {"Select Course","B. Com", "B.A", "B.Sc. Medical", "B.Sc. Non-Medical", "BCA"};
    String SemesterCount1[] = {"Select Semester","1", "2", "3", "4", "5", "6"};
    String SemesterCount2[] = {"Select Semester","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String nil1[]={"Select Course"};
    String nil2[]={"Select Semester"};
    String CourseT;
    String Course;
    String Semester;



    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.syllabus, container, false);

        courseTypeSpin = (Spinner) view.findViewById(R.id.courseTypeSpin);
        courseSpin = (Spinner) view.findViewById(R.id.courseSpin);
        semesterSpin = (Spinner) view.findViewById(R.id.semesterSpin);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CourseType);
        courseTypeSpin.setAdapter(arrayAdapter);

        courseTypeSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, HonorCourses);
                    courseSpin.setAdapter(arrayAdapter);
                }
                if (i == 2) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, IntegratedCourses);
                    courseSpin.setAdapter(arrayAdapter);
                }
                if (i == 3) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, PostgraduateCourses);
                    courseSpin.setAdapter(arrayAdapter);
                }
                if (i == 4) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, UndergraduateCourses);
                    courseSpin.setAdapter(arrayAdapter);
                }
                if (i == 1 || i== 2 || i==3 ||i==4 ) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nil2);
                    semesterSpin.setAdapter(arrayAdapter);
                }
                if (i == 0) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nil1);
                    courseSpin.setAdapter(arrayAdapter);

                    ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nil2);
                    semesterSpin.setAdapter(arrayAdapter1);
                }
                if(i != 0)
                {
                    String Selected = adapterView.getItemAtPosition(i).toString();
                    CourseT=Selected;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        courseSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Selection = adapterView.getItemAtPosition(i).toString();

                if (Selection == "Commerce" || Selection == "History") {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SemesterCount1);
                    semesterSpin.setAdapter(arrayAdapter);
                }
                if (Selection == "Economics" || Selection == "English") {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SemesterCount2);
                    semesterSpin.setAdapter(arrayAdapter);
                }
                if (Selection == "B. Com" || Selection == "B.A" || Selection == "B.Sc. Medical" || Selection == "B.Sc. Non-Medical" || Selection == "BCA") {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, SemesterCount1);
                    semesterSpin.setAdapter(arrayAdapter);
                }
                if (Selection == "Arabic") {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, NULL);
                    semesterSpin.setAdapter(arrayAdapter);
                }
                if(i != 0)
                {
                    String Selected = adapterView.getItemAtPosition(i).toString();
                    Course=Selected;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        semesterSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                       if(isOnline())
                       {
                       String Selected = adapterView.getItemAtPosition(i).toString();
                       Semester = Selected;
                           Intent intent = new Intent(getActivity(), SyllabusActivity.class);
                           intent.putExtra("courseType",CourseT);
                           intent.putExtra("course",Course);
                           intent.putExtra("semester",Semester);
                           startActivity(intent);

                      }
                       else Toast.makeText(getActivity(),"No Internet",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }


    public boolean isOnline() {

        ConnectivityManager cm =
                (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


}
